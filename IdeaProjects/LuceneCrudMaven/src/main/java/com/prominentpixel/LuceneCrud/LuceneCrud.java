package com.prominentpixel.LuceneCrud;

import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.apache.lucene.index.DirectoryReader.open;

public class LuceneCrud {
    public LuceneCrud() throws IOException {
    }

    //numericField.setIntValue(i.intValue());
    public int[] id={1,2,3,4,5};
    public String[] quetion={"what is your name","what is your age","what is your birth date","what is your age","what is your birth palce"};

  private static IndexWriter getIndexWriter() throws IOException
    {
        Directory dir = FSDirectory.open(Paths.get("/home/pp-5/index"));
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        return new IndexWriter(dir,config);
    }
    public void setUp() throws IOException
    {

        // directory = new RAMDirectory();
        IndexWriter writer=getIndexWriter();
        for(int i=0;i<id.length;i++)
        {
            Document doc = new Document();
            doc.add(new IntPoint("id",id[i]));
            doc.add(new StringField("quetion",quetion[i],Field.Store.YES));
            writer.addDocument(doc);

        }

        writer.close();
    }
   /*public void delete() throws IOException{
        IndexWriter writer = getIndexWriter();
       Scanner sc=new Scanner(System.in);
       System.out.println("enter deelete id number:");
       String id=sc.nextLine();
        writer.deleteDocuments(new Term("id",id));
        writer.commit();
        writer.close();
    }*/

    /*public void upDate() throws IOException {
        IndexWriter writer =getIndexWriter();
        Document doc=new Document();
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter a update id:");
        String id=scanner.next();
        System.out.println("update a question:");
        String question=scanner.nextLine();
        doc.add(new TextField("id",id,Field.Store.YES));
        doc.add(new TextField("quetion", question, Field.Store.YES));
        writer.updateDocument(new Term("id",id),doc);
         // System.out.println(doc);
        writer.close();
     }
     public void search() throws IOException {
        Term term=new Term("quetion","date");
        Query q=new TermQuery(term);

       Directory indexDirectory = FSDirectory.open(Paths.get("C:/Users/GOPAL PARMAR/Desktop/index1"));
        IndexReader reader = open(indexDirectory);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, 100);//TODO what is 100
        ScoreDoc[] hits = docs.scoreDocs;//Todo what is scoredocs

        for (int i=0;i<hits.length;i++)
        {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println(d.get("quetion"));
        }
        reader.close();
      }*/
    public static void main(String[] args) throws IOException {
        LuceneCrud lc=new LuceneCrud();
        lc.setUp();
        //lc.delete();
        //  lc.upDate();
       //  lc.search();
    }
}
