import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;

import javax.xml.namespace.QName;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.apache.lucene.index.DirectoryReader.open;

class simple {


    //public String[] id={"1","2","3"};
   // public String[] quetion={"what is your name","what is your age","what is your birth date"};
    public String id;
    public String question;

    Directory dir=new RAMDirectory();
    public StandardAnalyzer analyzer = new StandardAnalyzer();
    public  IndexWriter getIndexWriter() throws IOException {
        IndexWriterConfig iwc=new IndexWriterConfig(analyzer);
        return new IndexWriter(dir,iwc);
    }
    Scanner sc=new Scanner(System.in);
    public void setUp() throws IOException
    {

        // directory = new RAMDirectory();
        IndexWriter writer=getIndexWriter();

        System.out.print("enter the id=");

        System.out.print("enter the Question=");
        question=sc.nextLine();
        Document doc = new Document();
        doc.add(new TextField("id",id,Field.Store.YES));
        doc.add(new TextField("quetion",question,Field.Store.YES));
        writer.addDocument(doc);
        //  System.out.println(doc);
        writer.close();
    }
    public void Delete() throws IOException{
        IndexWriter writer = getIndexWriter();
        System.out.print("enter the id=");
        id=sc.nextLine();
        writer.deleteDocuments(new Term("id",id));
        writer.commit();
        writer.close();
    }
    public void update() throws IOException {
        IndexWriter writer =getIndexWriter();
        Document doc=new Document();
        System.out.println("update a id=");
        id=sc.nextLine();
        System.out.println("update a question=");
        doc.add(new TextField("id", id ,Field.Store.YES));
        doc.add(new TextField("quetion",question, Field.Store.YES));
        writer.updateDocument(new Term("id","1"),doc);
        writer.close();
    }

    public void Search() throws IOException {
        Term term=new Term("quetion","own");
        Query q=new TermQuery(term);

        IndexReader reader = open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, 100);
        ScoreDoc[] hits = docs.scoreDocs;

        for (int i=0;i<hits.length;++i)
        {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println(d.get("quetion"));
        }
        reader.close();
    }



    public static void main(String[] args) throws IOException {
        simple s1=new simple();
        s1.setUp();
        s1.Delete();
        //s1.update();
    }

}