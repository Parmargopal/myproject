package com.ProminanatPixel.Analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.StopAnalyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.StringReader;

public class stopanalyzer {
    void Stopana()throws IOException
    {
        String str="the emailid parmargopal@gmail.com";
        Analyzer ast=new StopAnalyzer(Version.LUCENE_36);
        TokenStream ts=ast.tokenStream("a",new StringReader(str));
        TermAttribute TA=ts.addAttribute(TermAttribute.class);
        while (ts.incrementToken())
        {
            System.out.println(TA);
        }
    }

    public static void main(String[] args)throws IOException {
        stopanalyzer stp=new stopanalyzer();
        stp.Stopana();

    }
}
