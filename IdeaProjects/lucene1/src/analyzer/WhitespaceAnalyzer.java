package analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.StringReader;

public class WhitespaceAnalyzer {
    void whitespaceAnalyzer() throws IOException {
        String s="MY GMAIL - ID PARMARGOPAL@055.COM ";
        Analyzer analyzer=new org.apache.lucene.analysis.WhitespaceAnalyzer(Version.LUCENE_36);
        TokenStream tokenStream=analyzer.tokenStream("content",new StringReader(s));
        TermAttribute termAttribute=tokenStream.addAttribute(TermAttribute.class);
        while (tokenStream.incrementToken())
        {
            System.out.println(termAttribute);
        }
    }
    public static void main(String[] args) throws IOException {
        WhitespaceAnalyzer whitespaceAnalyzer=new WhitespaceAnalyzer();
        whitespaceAnalyzer.whitespaceAnalyzer();
    }
}
