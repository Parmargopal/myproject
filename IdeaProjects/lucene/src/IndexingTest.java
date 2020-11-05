import junit.framework.TestCase;

import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import java.io.IOException;


/**
 * adding documents to an index
 * @author liang
 *
 */
/*public class IndexingTest extends TestCase {

    protected String[] ids = {"1","2"};
    protected String[] unindexed = {"Netherlands","Italy"};
    protected String[] unstored = {"Amsterdam has lots of bridges",
            "Venice has lots of canals"
    };
    protected String[] text = {"Amsterdam","Venice"};
    private Directory directory;

    protected void setUp() throws Exception{//a
        directory = new RAMDirectory();

        IndexWriter writer = getWriter();//b
        for(int i=0;i<ids.length;i++){//c
            Document doc  = new Document();
            doc.add(new Field("id",ids[i],Field.Store.YES,Field.Index.NOT_ANALYZED));
            doc.add(new Field("country",unindexed[i],Field.Store.YES,
                    Field.Index.NO));
            doc.add(new Field("contents",unstored[i],Field.Store.NO,
                    Field.Index.ANALYZED));
            doc.add(new Field("city",text[i],Field.Store.YES,
                    Field.Index.ANALYZED));
            writer.addDocument(doc);
        }
        writer.close();
    }

    private IndexWriter getWriter() throws IOException {//d
        return new IndexWriter(directory,new WhitespaceAnalyzer(),IndexWriter.MaxFieldLength.UNLIMITED);
    }

    protected int getHitCount(String fieldName,String searchString) throws IOException{
        IndexSearcher searcher = new IndexSearcher(directory);//e
        Term t = new Term(fieldName,searchString);
        Query query = new TermQuery(t);//f
//		int hitCount = TestUtil.hitCount(searcher,query);//g
        int hitCount = searcher.search(query, 1).totalHits;
        searcher.close();
        return hitCount;
    }

    public void testIndexWrtier() throws IOException{
        IndexWriter writer = getWriter();
        assertEquals(ids.length,writer.numDocs());//h
    }

    public void testIndexReader() throws IOException{
        IndexReader reader = IndexReader.open(directory);
        assertEquals(ids.length,reader.maxDoc());//i
        assertEquals(ids.length,reader.numDocs());
        reader.close();
    }

    public void testDeleteBeforeIndexMerge() throws IOException{
        IndexWriter writer = getWriter();
        assertEquals(2, writer.numDocs());//1
        writer.deleteDocuments(new Term("id","1"));//2
        writer.commit();
        assertTrue(writer.hasDeletions());//index contains deletions
        assertEquals(2, writer.maxDoc());
        assertEquals(1, writer.numDocs());//1 indexed doucment,1 deleted document
        writer.close();
    }

    public void testDeleteAfterIndexMerge() throws IOException{
        IndexWriter writer = getWriter();
        assertEquals(2, writer.numDocs());
        writer.deleteDocuments(new Term("id","1"));
        writer.optimize();
        writer.commit();
        assertFalse(writer.hasDeletions());
        assertEquals(1, writer.maxDoc());//1 indexed document,0 deleted documents
        assertEquals(1, writer.numDocs());
        writer.close();
    }

    public void testFieldIndex() throws IOException{
        //index no
        IndexSearcher searcher = new IndexSearcher(directory);
        Term term = new Term("country","Italy");
        Query query = new TermQuery(term);
        int hitCount = TestUtil.hitCount(searcher,query);//g
        assertEquals(0, hitCount);

        //index analyzer
        term = new Term("contents","bridges");
        query = new TermQuery(term);
        hitCount = TestUtil.hitCount(searcher, query);
        searcher.close();
        assertEquals(1, hitCount);
    }

    public void testUpdate() throws IOException{
        assertEquals(1, getHitCount("city", "Amsterdam"));
        IndexWriter writer = getWriter();

        Document doc = new Document();
        doc.add(new Field("id","1",Field.Store.YES,Field.Index.NOT_ANALYZED));
        doc.add(new Field("country","Netherlands",Field.Store.YES,
                Field.Index.NO));
        doc.add(new Field("contents","Amsterdam has lots of bridges",
                Field.Store.NO,Field.Index.ANALYZED));
        doc.add(new Field("city","Haag",Field.Store.YES,Field.Index.ANALYZED));
        writer.updateDocument(new Term("id","1"), doc);
        writer.close();

        assertEquals(0, getHitCount("city", "Amsterdam"));

        assertEquals(1, getHitCount("city", "Haag"));

    }
}*/