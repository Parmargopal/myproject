import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.BytesRef;

import static org.apache.lucene.index.DirectoryReader.*;

//TODO:FOLLOW CODING CONVENTION
class LuceneAddElement {
    public static void main(String[] args) throws IOException, ParseException {

        StandardAnalyzer analyzer = new StandardAnalyzer();
        Directory dir = FSDirectory.open(Paths.get("C:/Users/GOPAL PARMAR/Desktop/index1/data.csv"));
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(dir, indexWriterConfig);
        addDoc(indexWriter, 1, "Abhay parmar", "160041",  70.41f,71.56);
        addDoc(indexWriter, 2, "gopal parmar", "160042",75.67f,72.63);
        addDoc(indexWriter, 3, "harshit kotadiya", "160043",80.96f,86.33);
        addDoc(indexWriter, 4, "jayal sikotra", "160044",97.56f,96.23);
        addDoc(indexWriter, 5, "nilesh nakum", "160045",99.45f,96.56);
        addDoc(indexWriter, 5, "parmar gopal", "160046",98.63f,98.45);
        indexWriter.close();


        /*Term term=new Term("name","abhay");
        Query q=new TermQuery(term);*/

        //TermRangeQuery termRangeQuery=new TermRangeQuery("name",new BytesRef("a"),new BytesRef("n"),true,false);
        /* Term term=new Term("name","gopa");
         PrefixQuery q= new PrefixQuery(term);*/

        /*   Term term=new Term("name","parkak");
            Query q = new FuzzyQuery(term);*/

        /*  Term term=new Term("name","g*l");
          Query q=new WildcardQuery(term);*/


      /*  IndexReader reader = open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);
       TopDocs docs = searcher.search(q,100);
        ScoreDoc[] hits = docs.scoreDocs;

        for (int i=0;i<hits.length;++i)
        {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println(d.get("name"));
        }
        reader.close();*/
    }

    private static void addDoc(IndexWriter w,int id, String name, String rollNo,float sscMarks,double hscMarks) throws IOException{
        Document doc = new Document();
        doc.add(new IntPoint("id",100));
        doc.add(new TextField("name", name, Field.Store.YES));
        doc.add(new StringField("rollNo", rollNo, Field.Store.YES));
        doc.add(new FloatPoint("sscMarks", sscMarks));
        doc.add(new DoublePoint("hscMark", hscMarks));

        w.addDocument(doc);

    }

}
