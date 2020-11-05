package com.ProminanatPixel.Analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.index.Term;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.StringReader;

public class whitespaceAnalyzer {
    void WhitespaceAnalyzer11() throws IOException {
        String s="my gmail id - parmargopal055@gmail.com";
        Analyzer aws=new WhitespaceAnalyzer(Version.LUCENE_36);
        TokenStream tw=aws.tokenStream("content",new StringReader(s));
        TermAttribute tr=tw.addAttribute(TermAttribute.class);
        while (tw.incrementToken())
        {
            System.out.println(tr);
        }
    }
    public static void main(String[] args) throws IOException {
        whitespaceAnalyzer ws=new whitespaceAnalyzer();
        ws.WhitespaceAnalyzer11();
    }
}
