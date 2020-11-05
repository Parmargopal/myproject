package filter;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.StringReader;

public class StandardFilter {
    void standardFilter()throws IOException
    {
        String string="my gmail id - parmargopal055@gmail.com";

        Tokenizer tokenizer = new StandardTokenizer(Version.LUCENE_36, new StringReader(string));
        TokenStream tokenStream=new org.apache.lucene.analysis.standard.StandardFilter(tokenizer);
        TermAttribute termAttribute=tokenStream.addAttribute(TermAttribute.class);
        while (tokenStream.incrementToken())
        {
            System.out.println(termAttribute);
        }
    }
    public static void main(String[] args) throws IOException {
        StandardFilter standardFilter=new StandardFilter();
        standardFilter.standardFilter();
    }

}
