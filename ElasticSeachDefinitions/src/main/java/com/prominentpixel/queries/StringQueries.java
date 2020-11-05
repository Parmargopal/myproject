package com.prominentpixel.queries;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;

import java.io.IOException;

public class StringQueries {
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
    public void matchQuery() throws IOException {
        MatchQueryBuilder queryBuilder=QueryBuilders.matchQuery("first_name","gopal nilesh abhay");
        SearchRequest searchRequest=new SearchRequest("studentofdata");
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder().query(queryBuilder);
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse=client.search(searchRequest, RequestOptions.DEFAULT);
        HighlightBuilder highlightBuilder=new HighlightBuilder().field("first_name");
        sourceBuilder.highlighter(highlightBuilder);
        System.out.println(searchResponse.getHits().getTotalHits());
        System.out.println(searchResponse);
    }
    public void pharseQuery() throws IOException {
        MatchPhraseQueryBuilder queryBuilder=QueryBuilders.matchPhraseQuery("emailid","nileshnakum@gmail.com");
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder().query(queryBuilder);
        SearchRequest searchRequest=new SearchRequest("employessdata");
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse=client.search(searchRequest,RequestOptions.DEFAULT);
        System.out.println("total hits="+searchResponse.getHits().getTotalHits());
        System.out.println(searchResponse);
    }
    public void multiMatchQuery() throws IOException {
        MultiMatchQueryBuilder queryBuilder=QueryBuilders.multiMatchQuery("gopalparmar","emailid","first_name");
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder().query(queryBuilder);
        SearchRequest request=new SearchRequest("employessdata").source(sourceBuilder);
        SearchResponse searchResponse=client.search(request,RequestOptions.DEFAULT);
        System.out.println("MultiMatch query="+searchResponse.getHits().getTotalHits());
        System.out.println(searchResponse);
    }
    public void closeConnection() throws IOException {
        if (client!=null)
        {
            client.close();
        }
    }
    public static void main(String[] args) throws IOException {
    StringQueries queries=new StringQueries();
    queries.clientConnection();
    queries.matchQuery();
    queries.pharseQuery();
    queries.multiMatchQuery();
    queries.closeConnection();
    }
}
