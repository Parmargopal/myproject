package com.prominentpixel.databaseprogram;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class DatabaseElsticserach {
    RestHighLevelClient client;
    public boolean clientConnection()
    {
        try {
            client=new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
            return true;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
    }
    public void databaseElasticsearch()
    {
        Connection c;
        Statement statement;
        try {
            String driverName="org.postgresql.Driver";
            Class.forName(driverName);
            c= DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeesdata","postgres","test123");
            statement=c.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * from employess");
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            System.out.println("columns counts:"+resultSetMetaData.getColumnCount());
            System.out.println("columns name:"+resultSetMetaData.getColumnName(1));
            int columnCount=resultSetMetaData.getColumnCount();
            System.out.println(columnCount);
            Map<String,Object> map=new LinkedHashMap<>(columnCount);
            while (resultSet.next())
            {

                for (int i=1;i<=columnCount;i++)
                {
                    map.put(resultSetMetaData.getColumnName(i),resultSet.getObject(i));
                }
                IndexRequest indexRequest=new IndexRequest("employessdata","employess").source(map);
                IndexResponse indexResponse=client.index(indexRequest, RequestOptions.DEFAULT);
            }
            resultSet.close();
            statement.close();
            c.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();

            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }

    public void closeConnection() throws IOException {
        if (client!=null)
        {
            client.close();
        }
    }
    public static void main(String[] args) throws IOException {
        DatabaseElsticserach databaseElsticSerach=new DatabaseElsticserach();
        databaseElsticSerach.clientConnection();
        databaseElsticSerach.databaseElasticsearch();
        databaseElsticSerach.closeConnection();

    }
}
