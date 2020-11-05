package com.ProminanatPixel.Analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.index.Term;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.StringReader;

public class standerdanalyzer {
    void Standerd()throws IOException
    {
        String str="my gmail id - parmargopal055@gmail.com";
        Analyzer ans=new StandardAnalyzer(Version.LUCENE_36);
        TokenStream ts=ans.tokenStream(null,new StringReader(str));
        TermAttribute term=ts.addAttribute(TermAttribute.class);
        while (ts.incrementToken())
        {
            System.out.println(term);
        }
    }
    public static void main(String[] args)throws IOException {
        standerdanalyzer st=new standerdanalyzer();
        st.Standerd();
    }
}
