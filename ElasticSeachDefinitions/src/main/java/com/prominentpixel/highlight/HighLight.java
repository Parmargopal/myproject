package com.prominentpixel.highlight;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;

import java.io.IOException;

public class HighLight {
    RestHighLevelClient client;
    public  boolean connectionClient()
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
    public void highLightQuery() throws IOException {
        TermQueryBuilder termQueryBuilder= QueryBuilders.termQuery("first_name","gopal");
        HighlightBuilder highlightBuilder=new HighlightBuilder().field("first_name");
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder().query(termQueryBuilder);
        searchSourceBuilder.highlighter(highlightBuilder);
        SearchRequest searchRequest=new SearchRequest("employessdata");
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse=client.search(searchRequest, RequestOptions.DEFAULT);

        System.out.println(searchResponse.getHits().getTotalHits());
        System.out.println(searchResponse);
    }
    public void closeClient() throws IOException {
        if (client!=null)
        {
            client.close();
        }
    }

    public static void main(String[] args) throws IOException {
        HighLight highLight=new HighLight();
        highLight.connectionClient();
        highLight.highLightQuery();
        highLight.closeClient();
    }
}
