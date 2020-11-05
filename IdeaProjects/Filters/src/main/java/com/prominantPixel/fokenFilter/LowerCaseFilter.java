package com.prominantPixel.fokenFilter;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;

import java.io.IOException;
import java.io.StringReader;

public class LowerCaseFilter {
    void lowerCaseFilter() throws IOException {
        String s="MY GMAIL - ID PARMARGOPAL@055.COM ";
        Tokenizer tokenizer=new WhitespaceTokenizer(new StringReader(s));
        TokenStream tw=new org.apache.lucene.analysis.LowerCaseFilter(tokenizer);
        TermAttribute tr=tw.addAttribute(TermAttribute.class);
        while (tw.incrementToken())
        {
            System.out.println(tr);
        }
    }
    public static void main(String[] args) throws IOException {
        LowerCaseFilter lowerCaseFilter=new LowerCaseFilter();
        lowerCaseFilter.lowerCaseFilter();
    }
}
