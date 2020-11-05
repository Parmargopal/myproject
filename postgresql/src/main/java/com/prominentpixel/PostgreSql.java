package com.prominentpixel;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class PostgreSql {
    public static void main(String[] args)  {
        Connection c;
        Statement statement;
        try {
            String driverName="org.postgresql.Driver";
            Class.forName(driverName);
            c= DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeesdata","postgres","test123");
            statement=c.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * from employess");
          /*  while (resultSet.next())
            {
                Integer id=resultSet.getInt("uid");
                String firstName=resultSet.getString("first_name");
                String lastName=resultSet.getString("last_name");
                String college=resultSet.getString("college");
                System.out.println("uid="+id);
                System.out.println("firsname="+firstName);
                System.out.println("lastname="+lastName);
                System.out.println("college="+college);
                System.out.println();
            }*/
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
                System.out.println(map);
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
}
