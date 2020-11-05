package analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.StringReader;



public class SimpleAnalyzer {
    void simpleAnalyzer() throws IOException
    {
        String text="MY NAME IS GOPAL PARMAR123";
        Analyzer analyzer=new org.apache.lucene.analysis.SimpleAnalyzer(Version.LUCENE_36);
        TokenStream tokenStream=analyzer.tokenStream("content",new StringReader(text));
        TermAttribute termAttribute=tokenStream.addAttribute(TermAttribute.class);
        while (tokenStream.incrementToken())
        {
            System.out.println(termAttribute);
        }

    }
    public static void main(String[] args) throws IOException {
    SimpleAnalyzer simpleAnalyzer=new SimpleAnalyzer();
    simpleAnalyzer.simpleAnalyzer();
    }
}
