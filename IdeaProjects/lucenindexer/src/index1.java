/*import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;

class Index1{
    public static void main(String[] args) throws Exception {

        String indexDir = "E:\\Lucene\\Index";
        String dataDir = "E:\\Lucene\\Data";
        //----------------claulate the time and number of indexing-------//
        long start = System.currentTimeMillis();
        Indexer indexer = new Indexer(indexDir);
        int numIndexed;
        try {
            numIndexed = indexer.index(dataDir, new TextFilesFilter());
        } finally {
            indexer.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("Indexing " + numIndexed + " files took "
                + (end - start) + " milliseconds");
    }
    //---------------*----------------//

    //-----create indexing ----//
    private IndexWriter writer;
    public Index1(String indexDir) throws IOException {
        Directory dir = FSDirectory.open(new File(indexDir));
        Analyzer an=new StandardAnalyzer(Version.LUCENE_30);
        writer = new IndexWriter(dir,an, true, IndexWriter.MaxFieldLength.UNLIMITED);
    }
    public void close() throws IOException {
        writer.close();
    }
    //--------*------//
    public int index(String dataDir, FileFilter filter)
            throws Exception {
        File[] files = new File(dataDir).listFiles();
        for (File f: files) {
            if (!f.isDirectory() && !f.isHidden() && f.exists() && f.canRead() && (filter == null || filter.accept(f)))
            {
                indexFile(f);
            }
        }
        return writer.numDocs();
    }
    private static class TextFilesFilter implements FileFilter {
        public boolean accept(File path) {
            return path.getName().toLowerCase()
                    .endsWith(".txt");
        }
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

}*/