import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class searcherindex{
    public static void main(String[] args) throws IOException, ParseException, IllegalArgumentException {

        String indexdir="E:\\Lucene\\index";
        String q="gopal";
        search(indexdir,q);
    }
    public static void search(String indexdir,String q) throws IOException, ParseException {
        Directory dic= FSDirectory.open(new File(indexdir));
        Analyzer an=new SimpleAnalyzer(Version.LUCENE_36);
        IndexSearcher IS=new IndexSearcher(dic);

        QueryParser qp=new QueryParser(Version.LUCENE_36,"content",an);

        Query q1=qp.parse(q);

        TopDocs td=IS.search(q1,100);

       //System.out.println(td.totalHits);
        System.out.println("Found " + td.totalHits + " "+ q );
     /*   for(ScoreDoc scoreDoc : td.scoreDocs) {
            Document doc = IS.doc(scoreDoc.doc);
            System.out.println(doc.get("fullpath"));
        }*/
        IS.close();

    }

}
