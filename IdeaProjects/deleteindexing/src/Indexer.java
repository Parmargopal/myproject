import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;

public class Indexer {

    private IndexWriter writer;

    public Indexer(String indexDirectoryPath) throws IOException {
        //this directory will contain the indexes
        Directory indexDirectory =
                FSDirectory.open(new File(indexDirectoryPath));

        //create the indexer
        writer = new IndexWriter(indexDirectory,
                new StandardAnalyzer(Version.LUCENE_36),true,
                IndexWriter.MaxFieldLength.UNLIMITED);
    }

    public void close() throws CorruptIndexException, IOException {
        writer.close();
    }
    private void deleteDocument(File file) throws IOException {
        //delete indexes for a file
        writer.deleteDocuments(
                new Term(LuceneConstants.FILE_NAME,file.getName()));

        writer.commit();
    }


    private void indexFile(File file) throws IOException {
        System.out.println("Deleting index: "+file.getCanonicalPath());
        deleteDocument(file);
    }

    public int createIndex(String dataDirPath, FileFilter filter)
            throws IOException {
        //get all files in the data directory
        File[] files = new File(dataDirPath).listFiles();

        for (File file : files) {
            if(!file.isDirectory()
                    && !file.isHidden()
                    && file.exists()
                    && file.canRead()
                    && filter.accept(file)
            ){
                indexFile(file);
            }
        }
        return writer.numDocs();
    }
}