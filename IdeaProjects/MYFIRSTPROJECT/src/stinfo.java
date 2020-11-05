import java.util.ArrayList;
import java.util.Iterator;

public class stinfo {
    public static void main(String[] args) {
        ArrayList s1=new ArrayList(10);
        s1.add(10);
        s1.add(20);
        s1.add(40);
        s1.add(1,35);
        s1.add(4,65);
        s1.remove(2);


        Iterator i1=s1.iterator();
         while (i1.hasNext())
         {
             System.out.println(i1.next());
         }

    }
}
