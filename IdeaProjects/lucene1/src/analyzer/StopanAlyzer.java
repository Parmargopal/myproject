package analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.StringReader;

class StopAnalyzer {
    void stopanAnalyzer()throws IOException
    {
        String str="the emailid parmargopal@gmail.com";
        Analyzer analyzer=new org.apache.lucene.analysis.StopAnalyzer(Version.LUCENE_36);
        TokenStream tokenStream=analyzer.tokenStream("a",new StringReader(str));
        TermAttribute termAttribute=tokenStream.addAttribute(TermAttribute.class);
        while (tokenStream.incrementToken())
        {
            System.out.println(termAttribute);
        }
    }

    public static void main(String[] args)throws IOException {
        StopAnalyzer stopAnalyzer=new StopAnalyzer();
        stopAnalyzer.stopanAnalyzer();

    }
}
