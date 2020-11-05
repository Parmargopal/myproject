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

import static org.apache.lucene.index.DirectoryReader.open;

public class LuceneCrud {
    public LuceneCrud() throws IOException {
    }
    public int[] id={1,2,3,4,5};
    public String[] name={"gopal parmar","Abhay manvar","jayal sikotra","nilesh nakum","vihal khudai"};
    public String[] rollno={"16cse073","16cse073","16cse073","16cse073","16cse073"};
    public  float[] sscmarks={72.5f,75.5f,76.8f,78.5f,79.6f};
    public  double[] hscmaeks={86,87,90,75,98};
        //Directory dir=new RAMDirectory();
  private static IndexWriter getIndexWriter() throws IOException
    {
        Directory dir = FSDirectory.open(Paths.get("C:/Users/GOPAL PARMAR/Desktop/index"));
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter writer = new IndexWriter(dir,config);
        return writer;
    }
    public void setUp() throws IOException
    {

        // directory = new RAMDirectory();
        IndexWriter writer=getIndexWriter();
        for(int i=0;i<id.length;i++)
        {
            Document doc = new Document();
            doc.add(new IntPoint("id",id[i]));
            doc.add(new TextField("quetion",name[i],Field.Store.YES));
            doc.add(new StringField("rollno", rollno[i], Field.Store.YES));
            doc.add(new FloatPoint("sscmarks", sscmarks[i]));
            doc.add(new DoublePoint("hscmark", hscmaeks[i]));
            writer.addDocument(doc);
            //  System.out.println(doc);
        }

        writer.close();
    }



  /*public void setUp() throws IOException
    {

       // directory = new RAMDirectory();
        IndexWriter writer=getIndexWriter();
        for(int i=0;i<id.length;++i)
        {
            Document doc = new Document();
            doc.add(new TextField("id",id[i],Field.Store.YES));
            doc.add(new TextField("quetion",quetion[i],Field.Store.YES));
            writer.addDocument(doc);
          //  System.out.println(doc);
        }

        writer.close();
    }*/
   /*public void delete() throws IOException{
        IndexWriter writer = getIndexWriter();
        writer.deleteDocuments(new Term("id","2"));
        writer.commit();
        writer.close();
    }*/

    /*public void upDate() throws IOException {
        IndexWriter writer =getIndexWriter();
        Document doc=new Document();
        doc.add(new TextField("id","1",Field.Store.YES));
        doc.add(new TextField("quetion", "own", Field.Store.YES));
        writer.updateDocument(new Term("id","1"),doc);
         // System.out.println(doc);
        writer.close();
     }*/

     /*public void search() throws IOException {
        Term term=new Term("quetion","date");
        Query q=new TermQuery(term);


       Directory indexDirectory = FSDirectory.open(Paths.get("C:/Users/GOPAL PARMAR/Desktop/index"));
        IndexReader reader = open(indexDirectory);
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
      }*/
    public static void main(String[] args) throws IOException {
        LuceneCrud lc=new LuceneCrud();
        lc.setUp();
        //lc.delete();
        //lc.upDate();
       //lc.search();
    }
}
