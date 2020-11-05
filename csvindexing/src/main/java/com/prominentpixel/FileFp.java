package com.prominentpixel;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FileFp {
    public static void main(String[] args) throws IOException {
        Directory dir= FSDirectory.open(Paths.get("/home/pp-5/indexing2"));
        IndexWriterConfig config=new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter writer=new IndexWriter(dir,config);
        List<String> result= Files.readAllLines(Paths.get("/home/pp-5/Downloads/ELK-20201022T063954Z-001/ELK/requirement-1-Lucene/FP-2019.csv"));
        result.remove(0);
        for (String s:result)
        {
            String string=s.replace("\"","");
            String[] data=string.split(",");
            add(writer,data[0],data[1],data[2],data[3],data[4]);

        }
        writer.commit();
        writer.close();

    }
    private static void add(IndexWriter w, String date, String link, String title, String body_text, String paper_id) throws IOException {
        Document document=new Document();
        document.add(new StringField("date", String.valueOf(date), Field.Store.YES));
        document.add(new StringField("link",link,Field.Store.YES));
        document.add(new StringField("title",title,Field.Store.YES));
        document.add(new StringField("body_text",body_text,Field.Store.YES));
        document.add(new StringField("paper_id", String.valueOf(paper_id),Field.Store.YES));
        w.addDocument(document);
    }
}
