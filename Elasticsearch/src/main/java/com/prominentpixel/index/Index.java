package com.prominentpixel.index;
import org.elasticsearch.action.IndicesRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.discovery.zen.NodesFaultDetection;
import org.elasticsearch.node.Node;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.DoubleStream;

public class Index {
    TransportClient client = null;
    public void createSettings() throws ExecutionException, InterruptedException {
        CreateIndexRequest request = new CreateIndexRequest("question");
        request.settings(Settings.builder()
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
        );
        CreateIndexResponse createIndexResponse = client.indices().create(request).get();
    }

    private NodesFaultDetection.PingRequest nodeBuilder() {
        return null;
    }

    /*public  void putdocument()
   {
       Map<String, Object> data = new HashMap<String, Object>();
        data.put("id",1);
        data.put("name","alok");
        data.put("rollno","16cse073");
       System.out.println(data);
   }*/
    public boolean initEStransportClinet()
    {
        try {
            // un-command this, if you have multiple node
            client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9200));
            return true;
        } catch (Exception ex) {
            //log.error("Exception occurred while getting Client : " + ex, ex);
            ex.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) throws Exception {
        Index index=new Index();
       // index.putdocument();


    }
}
