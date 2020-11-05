package org.example;
/*
import java.io.IOException;
import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.core.*;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;*/



import java.io.IOException;

import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;


public class App
{
    public String[] id={"1","2","3"};
    protected String[] quetion={"abc","xyz","mno"};
    private Directory directory;
    /*------add------*/
    protected void setup() throws IOException
    {
        directory = new RAMDirectory();
        IndexWriter writer=getWriter();
        for(int i=0;i<id.length;i++)
        {
            Document doc = new Document();
            doc.add(new Field("id",id[i],Field.Store.YES,Field.Index.NOT_ANALYZED));
            doc.add(new Field("quetion",quetion[i],Field.Store.YES,Field.Index.NOT_ANALYZED));
            writer.addDocument(doc);
        }
        writer.close();
    }
    private IndexWriter getWriter() throws IOException{//d
        return new IndexWriter(directory,new WhitespaceAnalyzer(),IndexWriter.MaxFieldLength.UNLIMITED);
    }

    /*---------delete-------*/

    public void Delete() throws IOException{
        IndexWriter writer = getWriter();
        writer.deleteDocuments(new Term("id","1"));
        writer.commit();
        writer.close();
    }

    /*-------update----*/

    public void update() throws IOException {
        IndexWriter writer =getWriter();
        Document doc=new Document();
        doc.add(new Field("id", "1",Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field("quetion", "own", Field.Store.YES, Field.Index.NOT_ANALYZED));
        writer.updateDocument(new Term("id","1"),doc);
        writer.close();
    }

    /*
    public void search() throws IOException {
        Term term=new Term("quetion","xyz");
        Query q=new TermQuery(term);
        IndexReader reader = open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, 100);
        ScoreDoc[] hits = docs.scoreDocs;

        for (int i=0;i<hits.length;++i)
        {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println(d.get("name"));
        }
        reader.close();
    }*/
}
