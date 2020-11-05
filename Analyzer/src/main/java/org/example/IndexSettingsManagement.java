package org.example;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsRequest;
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsResponse;
import org.elasticsearch.action.admin.indices.settings.put.UpdateSettingsRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.ExecutionException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class IndexSettingsManagement {

    TransportClient client = null;
    String indexName,indexTypeName;

    public static void main(String[] args) {
        IndexSettingsManagement manageSettings = new IndexSettingsManagement();
        try {
            manageSettings.initESTransportClient();

            manageSettings.createSettings();
            manageSettings.getSettings();
            manageSettings.createSettingsWithAnalyzer();
            manageSettings.getSettingsWithAnalyzer();
            manageSettings.updateSettings();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            manageSettings.closeTransportClient(); //close transport client
        }
    }


    public boolean initESTransportClient()
    {
        try {
            client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(
                            new TransportAddress(InetAddress.getByName("localhost"), 9300));

            return true;
        } catch (Exception ex) {

            ex.printStackTrace();
            return false;
        }
    }

    public IndexSettingsManagement(){
        indexName = "indexsettingexampleone";
        indexTypeName = "bulkindexingone";
    }

    public void createSettings() throws ExecutionException, InterruptedException {
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        request.settings(Settings.builder()
                .put("index.max_inner_result_window", 250)
                .put("index.write.wait_for_active_shards", 1)
                .put("index.query.default_field", "paragraph")
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
        );
        CreateIndexResponse createIndexResponse = client.admin().indices().create(request).get();
        System.out.println("Index : " + createIndexResponse.index() + " Created");
        getSettings();
    }

    public void createSettingsWithAnalyzer() throws ExecutionException, InterruptedException, IOException {
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        request.settings(Settings.builder()
                .put("index.max_inner_result_window", 250)
                .put("index.write.wait_for_active_shards", 1)
                .put("index.query.default_field", "paragraph")
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
                .loadFromSource(Strings.toString(jsonBuilder()
                        .startObject()
                        .startObject("analysis")
                        .startObject("analyzer")
                        .startObject("englishAnalyzer")
                        .field("tokenizer", "standard")
                        .field("char_filter", "html_strip")
                        .field("filter", new String[]{"snowball", "standard", "lowercase"})
                        .endObject()
                        .endObject()
                        .endObject()
                        .endObject()), XContentType.JSON)
        );
        CreateIndexResponse createIndexResponse = client.admin().indices().create(request).get();
        System.out.println("Index : "+createIndexResponse.index()+" Created");
        getSettingsWithAnalyzer();
    }




    public void getSettings() throws ExecutionException, InterruptedException {
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest();
        GetSettingsResponse indexResponse = client.admin().indices().getSettings(getSettingsRequest).get();
        Settings settings = indexResponse.getIndexToSettings().get(indexName);
        System.out.println("index.max_inner_result_window : "+settings.get("index.max_inner_result_window"));
        System.out.println("index.write.wait_for_active_shards : "+settings.get("index.write.wait_for_active_shards"));
        System.out.println("index.query.default_field : "+settings.get("index.query.default_field"));
        System.out.println("index.number_of_shards : "+settings.get("index.number_of_shards"));
        System.out.println("index.number_of_replicas : "+settings.get("index.number_of_replicas"));
    }
    public void getUpdatedSettings() throws ExecutionException, InterruptedException {
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest();
        GetSettingsResponse indexResponse = client.admin().indices().getSettings(getSettingsRequest).get();
        Settings settings = indexResponse.getIndexToSettings().get(indexName);
        System.out.println("index.max_inner_result_window : "+settings.get("index.max_inner_result_window"));
    }

    public void getSettingsWithAnalyzer() throws ExecutionException, InterruptedException {
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest();
        GetSettingsResponse indexResponse = client.admin().indices().getSettings(getSettingsRequest).get();
        Settings settings = indexResponse.getIndexToSettings().get(indexName);

        for(String key : settings.keySet()){
            System.out.println(key+" : "+settings.get(key));
        }
    }

    public void updateSettings() throws ExecutionException, InterruptedException {

        UpdateSettingsRequest request = new UpdateSettingsRequest(indexName);
        String settingKey = "index.max_inner_result_window";
        int settingValue = 100;
        Settings settings =
                Settings.builder()
                        .put(settingKey, settingValue)
                        .build();
        request.settings(settings);
        AcknowledgedResponse updateSettingsResponse =
                client.admin().indices().updateSettings(request).get();

        System.out.println("IsAcknowledged : "+updateSettingsResponse.isAcknowledged());
        getUpdatedSettings();
    }


    public void refreshIndices(){
        client.admin().indices()
                .prepareRefresh(indexName)
                .get();
    }

    public void closeTransportClient(){
        if(client!=null){
            client.close();
        }
    }

}
