package com.prominentpixel;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class CsvFileIndexing {
    public static void main(String[] args) throws IOException, ParseException {

        Scanner scanner=new Scanner(System.in);
        FileReader reader=new FileReader("/home/pp-5/IdeaProjects/csvindexinglucene/src/main/java/com/prominentpixel/datas.properties");
        Properties properties=new Properties();
        properties.load(reader);
        Directory fsDirectory= FSDirectory.open(Paths.get(properties.getProperty("dirpath")));

        IndexWriterConfig config=new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter writer=new IndexWriter(fsDirectory,config);
        File file=new File(properties.getProperty("filepath"));
        String[] list=file.list();

       /*System.out.println(list);*/
        for (String l1:list) {
            List<String> fileLines = Files.readAllLines(Paths.get(file + "/" + l1));
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
            String headerLine = fileLines.get(0);
            String[] headers = headerLine.split(",");
            for (String line : fileLines) {
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                try {
                    Document document = new Document();
                    int dataIndex = 0;
                    for (String header : headers) {
                     //   document.add(new StringField(header, data[dataIndex++], Field.Store.YES));
                        System.out.print(header+" "+data[dataIndex++]);
                    }
                    System.out.println();
                    writer.addDocument(document);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        writer.commit();
        writer.close();
    }
}
