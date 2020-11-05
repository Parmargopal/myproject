package com.prominentpixel.LuceneCrud;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.apache.lucene.index.DirectoryReader.open;


public class LuceneCrudUser {
     //int id;
     String id,question,status,level,type,categoryid;
  private static IndexWriter getIndexWriter() throws IOException
    {
        Directory dir = FSDirectory.open(Paths.get("C:/Users/GOPAL PARMAR/Desktop/index"));
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        return new IndexWriter(dir,config);
    }
    Scanner sc=new Scanner(System.in);
    public void setUp() throws IOException
    {
        IndexWriter writer=getIndexWriter();
        for(int i=0;i<5;i++)
        {
            System.out.print("enter a id:");
            //id=sc.nextInt();
            id=sc.nextLine();
            System.out.print("enter a Question:");
            question= sc.nextLine();
            System.out.print("enter a status [ACTIVE/INACTIVE]:");
            status=sc.nextLine();
            System.out.print("enter a categoryid:");
            categoryid=sc.nextLine();
            System.out.print("enter a level [BEGGINER,INTRMIDEATE,EXPERT]:");
            level=sc.nextLine();
            System.out.print("enter a type [SINGLE,MULTI]:");
            type=sc.nextLine();
            Document doc = new Document();
            doc.add(new StringField("id",id,Field.Store.YES));
            doc.add(new StringField("question",question,Field.Store.YES));
            doc.add(new StringField("status",status,Field.Store.YES));
            doc.add(new StringField("categoryid",categoryid,Field.Store.YES));
            doc.add(new StringField("level",level,Field.Store.YES));
            doc.add(new StringField("type",type,Field.Store.YES));
            writer.addDocument(doc);
        }

        writer.close();
    }
   public void delete() throws IOException{
        IndexWriter writer = getIndexWriter();
        System.out.print("enter delete id:");
        id=sc.nextLine();
        writer.deleteDocuments(new Term("id",id));
        writer.commit();
        writer.close();
    }

   public void update() throws IOException {
        IndexWriter writer =getIndexWriter();
            System.out.print("update a id:");
            id = sc.nextLine();
            System.out.print("update a Question:");
            question = sc.nextLine();
            System.out.print("update a status [ACTIVE/INACTIVE]:");
            status = sc.nextLine();
            System.out.print("update a categoryid:");
            categoryid = sc.nextLine();
            System.out.print("update a level [BEGGINER,INTRMIDEATE,EXPERT]:");
            level = sc.nextLine();
            System.out.print("update a type [SINGLE,MULTI]:");
            type = sc.nextLine();
            Document doc = new Document();
            doc.add(new StringField("id", id,Field.Store.YES));
            doc.add(new StringField("question", question, Field.Store.YES));
            doc.add(new StringField("status", status, Field.Store.YES));
            doc.add(new StringField("categoryid", categoryid, Field.Store.YES));
            doc.add(new StringField("level", level, Field.Store.YES));
            doc.add(new StringField("type", type, Field.Store.YES));
            writer.updateDocument(new Term("id",id), doc);
            writer.close();
   }

     public void search() throws IOException {
         System.out.print("enter field name:");
         String field=sc.nextLine();
         System.out.print("enter search name:");
         String name=sc.nextLine();
        Term term=new Term(field,name);
        Query q=new TermQuery(term);
        Directory indexDirectory =FSDirectory.open(Paths.get("C:/Users/GOPAL PARMAR/Desktop/index"));
        IndexReader reader = open(indexDirectory);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, 100);//TODO what is 100
        ScoreDoc[] hits = docs.scoreDocs;//Todo what is scoredocs

         for (ScoreDoc hit : hits) {
             int docId = hit.doc;
             Document d = searcher.doc(docId);
             System.out.println(d.get(field));
         }
        reader.close();
      }



    public static void main(String[] args) throws IOException {
        LuceneCrudUser lc=new LuceneCrudUser();
        lc.setUp();
        lc.delete();
        lc.update();
        lc.search();
    }
}
