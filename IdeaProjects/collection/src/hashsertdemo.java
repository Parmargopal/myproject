import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class hashsertdemo {
    public static void main(String[] args) {
        HashSet<emp> h = new HashSet<emp>();

        emp e1 = new emp(111, "gopal");
        emp e2 = new emp(112, "gopal");
        h.add(e1);
        h.add(e2);

        System.out.println(h);
        Iterator i1 = h.iterator();
        while (i1.hasNext()) {
            System.out.println(i1.next());
        }
    }
}
    class emp{
        int id;
        String name;
        emp(int id,String name)
        {
         this.id=id;
         this.name=name;
        }

        @Override
        public String toString() {
            return id+" "+name;
        }

        @Override
        public boolean equals(Object o) {

            emp e1=(emp)o;
            if (this.id==e1.id)
            {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }

