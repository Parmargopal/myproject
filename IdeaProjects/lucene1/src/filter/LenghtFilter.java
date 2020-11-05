package filter;

import org.apache.lucene.analysis.LengthFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.WhitespaceTokenizer;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;

import java.io.IOException;
import java.io.StringReader;

public class LenghtFilter {
    void lenghtFilter() throws IOException {
        String s="my name is parmar gopal manojbhai nitin nasit";
        Tokenizer tokenizer=new WhitespaceTokenizer(new StringReader(s));
        TokenStream tokenStream= new LengthFilter(tokenizer, 2, 5);
        TermAttribute termAttribute=tokenStream.addAttribute(TermAttribute.class);
        while (tokenStream.incrementToken())
        {
            System.out.println(termAttribute);
        }
    }
    public static void main(String[] args) throws IOException {
        LenghtFilter lenghtFilter=new LenghtFilter();
        lenghtFilter.lenghtFilter();
    }
}
