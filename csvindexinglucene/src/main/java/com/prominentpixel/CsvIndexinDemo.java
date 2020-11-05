package com.prominentpixel;
import org.apache.lucene.document.Document;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvIndexinDemo {
    public void csvIndexing() throws IOException {
       // IndexWriter indexWriter = getIndexWriter();
        Document document = new Document();

        List<String> files = Files.readAllLines(Paths.get("/home/pp-5/Downloads/ELK-20201022T063954Z-001/ELK/requirement-1-Lucene/df.csv"));
        files.remove(0);
        for (String result : files) {
           // String str = result.replace(",$", "");
            String[] data = result.split(",",-1);
            try {
                System.out.println("date="+ data[0]+" "+"title= "+data[1]+" "+"content="+data[2]);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }

        }
    }
    public static void main(String[] args) throws IOException {

        CsvIndexinDemo csvIndexinDemo=new CsvIndexinDemo();
        csvIndexinDemo.csvIndexing();
    }
}
