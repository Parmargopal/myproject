import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
public class sta {
    public static List tokenizeString(Analyzer analyzer, String str) throws IOException{
        List result = new ArrayList<>();
        try {
            TokenStream stream  = analyzer.tokenStream(null, new StringReader(str));
            stream.reset();
            while (stream.incrementToken()) {
                result.add(stream.getAttribute(CharTermAttribute.class).toString());
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
