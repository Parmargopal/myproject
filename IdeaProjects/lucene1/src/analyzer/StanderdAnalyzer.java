package analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.StringReader;

public class StanderdAnalyzer {
    void standerdAnalyzer()throws IOException
    {
        String string="my gmail id - parmargopal055@gmail.com";
        Analyzer analyzer=new StandardAnalyzer(Version.LUCENE_36);
        TokenStream tokenStream=analyzer.tokenStream(null,new StringReader(string));
        TermAttribute termAttribute=tokenStream.addAttribute(TermAttribute.class);
        while (tokenStream.incrementToken())
        {
            System.out.println(termAttribute);
        }
    }
    public static void main(String[] args)throws IOException {
        StanderdAnalyzer standerdAnalyzer=new StanderdAnalyzer();
        standerdAnalyzer.standerdAnalyzer();
    }
}
