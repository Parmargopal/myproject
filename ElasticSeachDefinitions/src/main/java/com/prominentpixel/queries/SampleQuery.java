package com.prominentpixel.queries;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

public class SampleQuery {
    RestHighLevelClient client;
    public boolean connectionClient()
    {
        try {
            client=new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
            return true;
        }
        catch (Exception exception)
        {
            return false;
        }
    }

    public void  termQuery() throws IOException {
        TermQueryBuilder queryBuilder= QueryBuilders.termQuery("company","tcs");
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder().query(queryBuilder);
        SearchRequest searchRequest=new SearchRequest("employessdata");
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse=client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println("termQuery total hits="+searchResponse.getHits().getTotalHits());
        System.out.println(searchResponse);
    }
    public void  booleanQuery() throws IOException {
        BoolQueryBuilder boolQueryBuilder= QueryBuilders.boolQuery().must(QueryBuilders.
                termsQuery("name","hardik","ronak")).should(QueryBuilders.rangeQuery("Enroll").gte("160040107001").lte("160040107010"));
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder().query(boolQueryBuilder);
        SearchRequest searchRequest=new SearchRequest("studentdata");
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse=client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println("boolean total hits="+searchResponse.getHits().getTotalHits());
        System.out.println(searchResponse);
    }
    public void wildCardQuery() throws IOException {
        WildcardQueryBuilder wildcardQueryBuilder=QueryBuilders.wildcardQuery("question","w*t");
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder().query(wildcardQueryBuilder);
        SearchRequest searchRequest=new SearchRequest("questiondatas");
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse=client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println("wildcard total hits="+searchResponse.getHits().getTotalHits());
        System.out.println(searchResponse);
    }
    public void rangeQuery() throws IOException {
        RangeQueryBuilder rangeQueryBuilder=QueryBuilders.rangeQuery("first_name").gte("abhay").lte("jayal");
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder().query(rangeQueryBuilder);
        SearchRequest searchRequest=new SearchRequest("employessdata");
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse=client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println("RangeQuery total hits="+searchResponse.getHits().getTotalHits());
        System.out.println(searchResponse);

    }
    public void prefixQuery() throws IOException {
        PrefixQueryBuilder queryBuilder=QueryBuilders.prefixQuery("company","re");
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder().query(queryBuilder);
        SearchRequest request=new SearchRequest("employessdata");
        request.source(sourceBuilder);
        SearchResponse response=client.search(request,RequestOptions.DEFAULT);
        System.out.println("Prefix Query total Hints="+response.getHits().getTotalHits());
        System.out.println(response);
    }
    public boolean colseConnection() throws IOException {
        if (client!=null)
        {
            client.close();
        }
            return true;
    }
    public static void main(String[] args) throws IOException {
        SampleQuery sampleQuery=new SampleQuery();
        sampleQuery.connectionClient();
        sampleQuery.termQuery();
        sampleQuery.booleanQuery();
        sampleQuery.wildCardQuery();
        sampleQuery.rangeQuery();
        sampleQuery.prefixQuery();
        sampleQuery.colseConnection();
    }
}
