package com.prominentpixel;

import org.apache.http.HttpHost;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PdfRead {
    RestHighLevelClient client;
    public boolean connectionClient()
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

    public void pdfReader() throws IOException {

        String filepath="/home/pp-5/Downloads/A Sample PDF.pdf";
        File file=new File(filepath);
        PDDocument document=PDDocument.load(file);
        PDFTextStripper textStripper=new PDFTextStripper();
        String text=textStripper.getText(document);
        Map<String,String> map=new HashMap();
        map.put("filepath",filepath);
        map.put("content",text);
        document.close();
        IndexRequest request=new IndexRequest("filedatas","file").source(map);
        IndexResponse response=client.index(request, RequestOptions.DEFAULT);


    }
    public void closeconnection() throws IOException {
        if (client!=null)
        {
            client.close();
        }
    }

    public static void main(String[] args) throws IOException {
        PdfRead pdfRead=new PdfRead();
        pdfRead.connectionClient();
        pdfRead.pdfReader();
        pdfRead.closeconnection();
    }
}
