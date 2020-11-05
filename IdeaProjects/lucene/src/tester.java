import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.util.List;

public class tester {
    public static void main(String[] args) throws IOException {
        String text = "The test email – mail@javacodegeeks.com";
        Analyzer analyzer = new WhitespaceAnalyzer();
        List ss=sta.tokenizeString(analyzer, text);
        System.out.print("==>"+ss+" \n");

        Analyzer analyzer1 = new SimpleAnalyzer();
        List ss1=sta.tokenizeString(analyzer1, text);
        System.out.print("==>"+ss1+" \n");


    }
}
