package filter;
import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;


import java.io.IOException;
import java.io.StringReader;

public class LowerCaseFilter {
    void lowerCaseFilter() throws IOException {
        String s="MY GMAIL - ID PARMARGOPAL@055.COM ";
        Tokenizer tokenizer=new WhitespaceTokenizer(new StringReader(s));
        TokenStream tokenStream=new org.apache.lucene.analysis.LowerCaseFilter(tokenizer);
        TermAttribute termAttribute=tokenStream.addAttribute(TermAttribute.class);
        while (tokenStream.incrementToken())
        {
            System.out.println(termAttribute);
        }
    }
    public static void main(String[] args) throws IOException {
        LowerCaseFilter lowerCaseFilter=new LowerCaseFilter();
        lowerCaseFilter.lowerCaseFilter();
    }
}
