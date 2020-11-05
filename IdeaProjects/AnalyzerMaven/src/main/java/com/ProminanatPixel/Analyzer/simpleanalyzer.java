package com.ProminanatPixel.Analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.index.Term;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.StringReader;

public class simpleanalyzer {
    void simpleAnalyzer() throws IOException
    {
        String text="MY NAME IS GOPAL PARMAR123";
        Analyzer an=new SimpleAnalyzer(Version.LUCENE_36);
        TokenStream tm=an.tokenStream("content",new StringReader(text));
        TermAttribute ta=tm.addAttribute(TermAttribute.class);
        while (tm.incrementToken())
        {
            System.out.println(ta);
        }

    }
    public static void main(String[] args) throws IOException {
    simpleanalyzer sa=new simpleanalyzer();
    sa.simpleAnalyzer();
    }
}
