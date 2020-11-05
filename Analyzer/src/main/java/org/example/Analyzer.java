package org.example;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;


import java.net.InetAddress;

public class Analyzer {
    RestHighLevelClient client=null;

    public void connectionClient()
    {

             client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9300, "http")));

    }
    public void analyzer()
    {
        //AnalyzerRequst analyzerRequst=AnalyzerRequst.withGlobalAnalyzer();
    }

    public void phraseSearch()
    {
        MatchPhraseQueryBuilder queryBuilder= QueryBuilders.matchPhraseQuery("name","gopal parmar");
        SearchResponse searchResponse=client.prepareSearch().setIndices("studentdata").setTypes("students").setQuery(queryBuilder).execute().actionGet();
        System.out.println("hit count"+searchResponse.getHits().getTotalHits());
        System.out.println(searchResponse);
    }

    public static void main(String[] args) {
        Analyzer analyzer=new Analyzer();
        analyzer.connectionClient();
        analyzer.phraseSearch();

    }
}
