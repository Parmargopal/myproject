package filter;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.standard.ClassicTokenizer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.StringReader;

public class StopFilter {
    void stopFilter()throws IOException
    {
        String string="my gmail id - parmargopal055@gmail.com";

        Tokenizer tokenizer = new ClassicTokenizer(Version.LUCENE_36, new StringReader(string));

        //TokenStream result = new org.apache.lucene.analysis.standard.StandardFilter(Version.LUCENE_36,tokenizer);
        TokenStream tokenStream=new org.apache.lucene.analysis.StopFilter(tokenizer, StopAnalyzer.ENGLISH_STOP_WORDS_SET);
        TermAttribute termAttribute=tokenStream.addAttribute(TermAttribute.class);
        while (tokenStream.incrementToken())
        {
            System.out.println(termAttribute);
        }
    }
    public static void main(String[] args) throws IOException {
        StopFilter stopFilter=new StopFilter();
        stopFilter.stopFilter();
    }
}
