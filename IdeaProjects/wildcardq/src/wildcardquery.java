import java.io.IOException;
import java.util.Scanner;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;



//TODO:FOLLOW CODING CONVENTION
class wildcardquery {
    public static void main(String[] args) throws IOException, ParseException {
        StandardAnalyzer analyzer = new StandardAnalyzer();
        Directory dic = new RAMDirectory();
        IndexWriterConfig iwc=new IndexWriterConfig(analyzer);
        IndexWriter w=new IndexWriter(dic,iwc);
        addDoc(w,"1","gopal abc","ec1");
        addDoc(w,"2","parmar","ec2");
        addDoc(w,"3","gopal xyz","ec3");
        addDoc(w,"4","parmar abc","ec4");
        addDoc(w,"5","parnar xyz","ec5");
        w.close();
        //store data formate in ? and *//example p*r,parm?r
        Scanner S1=new Scanner(System.in);
        System.out.print("enter wildcard query String:");
        String str=S1.nextLine();
        Term term=new WildcardQuery("name",str);
        Query q=new WildcardQuery(term);

        IndexReader reader = IndexReader.open(dic);
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


    }

    private static void addDoc(IndexWriter w,String id, String name, String rollno) throws IOException{
        Document doc = new Document();
        doc.add(new TextField("id", name, Field.Store.YES));
        doc.add(new TextField("name", name, Field.Store.YES));
        doc.add(new TextField("rollno", rollno, Field.Store.YES));
        w.addDocument(doc);

    }


}