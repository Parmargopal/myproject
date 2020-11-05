import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;


import java.io.IOException;
import java.io.StringReader;

public class myproject {
    private void display() throws IOException {
        String text = "my gmail is parmargopal@gmail.com";
   //     Analyzer an=new StandardAnalyzer(Version.LUCENE_86);
        //TokenStream ts=an.tokenStream("contents",new StringReader(text));
        //TermAttribute term = ts.addAttribute(TermAttribute.class);

    }

    public static void main(String[] args) {
    myproject mi=new myproject();
    }
}
