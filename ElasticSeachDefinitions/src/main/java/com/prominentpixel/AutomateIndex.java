package com.prominentpixel;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AutomateIndex {
    RestHighLevelClient client;
    public boolean connection()
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
    public void index() throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.print("student name:");
        String sname=scanner.next();
        System.out.print("student standard class:");
        int standard=scanner.nextInt();
        System.out.print("student rollno:");
        long rollno=scanner.nextLong();
        System.out.print("school name");
        String school=scanner.next();
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("name",sname);
        map.put("standard",standard);
        map.put("rollno",rollno);
        map.put("school",school);
        IndexRequest request=new IndexRequest("schooldata","student").source(map);
        IndexResponse response=client.index(request, RequestOptions.DEFAULT);

    }
    public void closeClient() throws IOException {
        if (client!=null)
        {
            client.close();
        }
    }
    public static void main(String[] args) throws IOException {
        AutomateIndex index=new AutomateIndex();
        index.connection();
        index.index();
        index.closeClient();
    }
}
