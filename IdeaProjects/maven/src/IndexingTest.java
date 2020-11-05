
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Before;
import org.junit.Test;

public class IndexingTest {

    /**
     * Ready to retrieve content
     */
    private String ids[]={"1","2","3"};
    private String citys[]={"qingdao","nanjing","shanghai"};
    private String descs[]={
            "Qingdao is a beautiful city.",
            "Nanjing is a city of culture.",
            "Shanghai is a bustling city."
    };

    private Directory dir; // directory

    @Before
    public void setUp() throws Exception {
        dir = FSDirectory.open (Paths.get ( "D: \\ lucene2")); // index file placement location
        IndexWriter writer = getWriter (); // write index
        for(int i=0;i<ids.length;i++){
            Document doc=new Document();
            doc.add (new StringField ( "id", ids [i], Field.Store.YES)); // id to traverse a string array contents, YES indicates index field values ​​stored, can query the index, the index can be printed
            doc.add (new StringField ( "city", citys [i], Field.Store.YES)); // string in a manner to traverse the array contents city
            doc.add (new TextField ( "desc", descs [i], Field.Store.NO)); // Text in a manner to traverse the array desc content, NO represents the field value is not stored, can query the index, the index can not be printed
            writer.addDocument (doc); // add documents
        }
        writer.close (); // close the write index
    }

    /**
     * Get IndexWriter examples
     * @return
     * @throws Exception
     */
    private IndexWriter getWriter()throws Exception{
        Analyzer analyzer = new StandardAnalyzer (); // standard tokenizer
        IndexWriterConfig iwc = new IndexWriterConfig (analyzer); // write the configuration index, a standard configuration tokenizer
        IndexWriter writer = new IndexWriter (dir, iwc); // write new index instance, the index file transfer needs to be placed and the position index path two configuration parameters
        return writer;
    }

    /**
     * Test wrote several documents
     * @throws Exception
     */
    @Test
    public void testIndexWriter()throws Exception{
        IndexWriter writer = getWriter (); // test writing a specified path channel element index
        System.out.println ( "written" + writer.numDocs () + "documents"); // print a document written several index
        writer.close();
    }

    /**
     * Test read documents
     * @throws Exception
     */
    @Test
    public void testIndexReader()throws Exception{
        IndexReader reader = DirectoryReader.open (dir); // read the index file under the specified path
        System.out.println ( "maximum number of documents:" + reader.maxDoc ()); // When not removed, the same number of maximum number of documents and the actual document
        System.out.println ( "The actual number of documents:" + reader.numDocs ());
        reader.close();
    }

    /**
     * Test deleted before the merger
     * @throws Exception
     */
    @Test
    public void testDeleteBeforeMerge()throws Exception{
        IndexWriter writer=getWriter();
        System.out.println ( "before deleting:" + writer.numDocs ());
        writer.deleteDocuments(new Term("id","1"));
        writer.commit();
        System.out.println("writer.maxDoc()："+writer.maxDoc());
        System.out.println("writer.numDocs()："+writer.numDocs());
        writer.close();

        /* out:
         * Before deleting: 3
         *	writer.maxDoc()：3
         *  writer.numDocs()：2
         */
    }

    /**
     * Test deleted after merger
     * @throws Exception
     */
    @Test
    public void testDeleteAfterMerge()throws Exception{
        IndexWriter writer=getWriter();
        System.out.println ( "before deleting:" + writer.numDocs ());
        writer.deleteDocuments(new Term("id","1"));
        writer.forceMergeDeletes (); // forced to delete
        writer.commit();
        System.out.println("writer.maxDoc()："+writer.maxDoc());
        System.out.println("writer.numDocs()："+writer.numDocs());
        writer.close();


    }

    /**
     * Testing Update
     * @throws Exception
     */
    @Test
    public void testUpdate()throws Exception{
        IndexWriter writer=getWriter();
        Document doc=new Document();
        doc.add(new StringField("id", "1", Field.Store.YES));
        doc.add(new StringField("city","qingdao",Field.Store.YES));
        doc.add(new TextField("desc", "dsss is a city.", Field.Store.NO));
        writer.updateDocument (new Term ( "id", "1"), doc); // update the document operation, the original index was still able to query, similar to adding a new change of index
        writer.close();
    }
}