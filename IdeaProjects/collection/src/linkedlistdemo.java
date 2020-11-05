import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class linkedlistdemo {
    public static void main(String[] args) {
        LinkedList l1=new LinkedList();
        l1.add("gopal");
        l1.add("parmar");
        l1.add("gopal1");
        l1.add("gopal2");
        System.out.println(l1);
        LinkedList l2=new LinkedList(l1);
        l2.add(1);
        l2.add(2);
        l2.add(3);
        l2.add(4);
        System.out.println(l2);

        Iterator i1=l2.iterator();
        while(i1.hasNext())
        {
            System.out.println(i1.next());
        }
        System.out.println("forward");
        ListIterator i2=l2.listIterator();
        while(i2.hasNext())
        {
            System.out.println(i2.next());
        }
        System.out.println("backword");
        while(i2.hasPrevious())
        {
            System.out.println(i2.previous());
        }
        System.out.println(l2.getFirst());
        System.out.println(l2.getLast());
        LinkedList l3=new LinkedList();
        /* stack emplement*/
        l3.push("gandu");
        l3.push("charshi");
        l3.pop();
    }
}
