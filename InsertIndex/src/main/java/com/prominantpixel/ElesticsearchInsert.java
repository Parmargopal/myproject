package com.prominantpixel;

import com.sun.security.ntlm.Client;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class ElasticseachInsert {
    public static void main(String[] args) throws IOException {
        insertAsJsonBuilder();
    }

    public static void insertMap() throws UnknownHostException {
        Map<String,Object> data = new HashMap<>();
        data.put("name","iPhoneX");
        data.put("category","Mobiles");
        data.put("description","Apple Mobiles");
        IndexResponse response = getClient().prepareIndex("otp", "items","3")
                .setSource(data).get();
    }

    public static Client getClient() throws UnknownHostException {
        Client client = new PreBuiltTransportClient(
                Settings.builder().put("client.transport.sniff", true)
                        .put("cluster.name","elasticsearch").build())
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9200));
        return client;
    }
}
