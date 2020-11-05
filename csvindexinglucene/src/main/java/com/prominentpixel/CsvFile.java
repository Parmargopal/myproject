package com.prominentpixel;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvFile {
    public static void main(String[] args) throws IOException {
        String line;
        File file = new File("/home/pp-5/files");
        String[] list = file.list();
        Directory directory= FSDirectory.open(Paths.get("/home/pp-5/a"));
        IndexWriterConfig config=new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter indexWriter=new IndexWriter(directory,config);
        Document document=new Document();
        for (String str : list) {
          //  BufferedReader reader = new BufferedReader(new FileReader(file+"/"+str));
            List<String> results=Files.readAllLines(Paths.get(file+"/"+str));
                try {

                    for (String value:results)
                    {
                        String[] data=value.split(",");
                        System.out.println("id="+data[0]+" question="+data[1]);
                    }

                }
                catch (Exception e)
                {
                    System.out.println(e);
                }

        }
        indexWriter.close();
    }
}
