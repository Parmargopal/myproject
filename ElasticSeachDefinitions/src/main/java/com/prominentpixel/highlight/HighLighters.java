package com.prominentpixel.highlight;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

public class HighLighters {
    TransportClient client;
    public boolean connectionClient()
    {

            try {
                client=new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"),9300));
                return true;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                return  false;
            }
    }
    public void termQuery()
    {

        TermQueryBuilder query = QueryBuilders.termQuery("Level", "export");
        HighlightBuilder highlightBuilder=new HighlightBuilder().field("Level");
        SearchResponse searchResponse=client.prepareSearch("questions").setTypes("quetiondata").highlighter(highlightBuilder).setQuery(query).setFrom(0).setSize(100).execute().actionGet();
        System.out.println(searchResponse.getHits().getTotalHits());
        System.out.println(searchResponse);
    }
    public void closeConnection()
    {
        if (client!=null)
        {
            client.close();
        }
    }

    public static void main(String[] args) {
        HighLighters highLighters=new HighLighters();
        highLighters.connectionClient();
        highLighters.termQuery();
        highLighters.closeConnection();
    }
}
