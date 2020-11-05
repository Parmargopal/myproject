package com.prominentpixel;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class CsvIndexingDF {
    public static void main(String[] args) throws IOException {
        
        FileReader reader=new FileReader("/home/pp-5/IdeaProjects/csvindexinglucene/src/data.properties");
        Properties properties=new Properties();
        properties.load(reader);
        Directory directory= FSDirectory.open(Paths.get(properties.getProperty("dir")));
        IndexWriterConfig indexWriterConfig=new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter indexWriter=new IndexWriter(directory,indexWriterConfig);
        int count=0;

            List<String> files= Files.readAllLines(Paths.get(properties.getProperty("filepath"+"/"+"")));
            files.remove(0);
            for (String results:files)
            {
              //  String str=results.replace("\"","");
                String data[]=results.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)",-1);
                try {
                    SimpleDateFormat dateFormat=new SimpleDateFormat("dd/mm/yyyy");
                    Date date=dateFormat.parse(data[0]);
                    add(indexWriter,date,data[1],data[2]);
                    System.out.println("date="+date+" "+" title="+data[1]+" "+"content="+data[2]);
                }
                catch (ArrayIndexOutOfBoundsException exception)
                {
                    System.out.println(exception);
                }
                catch (ParseException e)
                {
                    System.out.println(e);
                }
            }
        indexWriter.close();
    }
   public static void add(IndexWriter writer,Date date,String title,String content) throws IOException {
        Document document=new Document();
        document.add(new StringField("Date", String.valueOf(date), Field.Store.YES));
        document.add(new StringField("Title",title,Field.Store.YES));
        document.add(new StringField("content",content,Field.Store.YES));
        writer.addDocument(document);
    }
}
