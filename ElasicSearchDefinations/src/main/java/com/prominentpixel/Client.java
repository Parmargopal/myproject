package com.prominentpixel;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Client {
    RestHighLevelClient client;
    public boolean restClient()
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
    public void indexCreate() throws ExecutionException, InterruptedException, IOException {
        CreateIndexRequest request=new CreateIndexRequest("clientdatas");
        request.settings(Settings.builder().put("index.max_inner_result_window", 250)
                .put("index.write.wait_for_active_shards", 1)
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2));
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);

    }
    public void clientData() throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter client First Name:");
        String firstName=scanner.next();
        System.out.print("Enter Client Last Name:");
        String lastName=scanner.next();
        System.out.print("Enter Client Email:");
        String email=scanner.next();
        System.out.print("Enter Client Phone No.:");
        long phone=scanner.nextLong();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("firstName",firstName);
        map.put("lastname",lastName);
        map.put("email",email);
        map.put("phone",phone);
        IndexRequest indexRequest=new IndexRequest("clientdatas","clients");
        indexRequest.source(map);
        IndexResponse indexResponse=client.index(indexRequest,RequestOptions.DEFAULT);
    }
    public void closeRestClient() throws IOException {
        if(client!=null){
            client.close();
        }
    }
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Client client=new Client();

        client.restClient();
        client.indexCreate();
        client.clientData();
        client.closeRestClient();

    }
}
