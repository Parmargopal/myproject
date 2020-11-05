import java.util.Enumeration;
import java.util.Vector;

public class vectordemo {
    public static void main(String[] args) {
        Vector v1=new Vector();
        v1.addElement("gopal");
        v1.addElement("parmar");
        v1.addElement("manojbhai");
        v1.addElement("ok");
        //  System.out.println(v1);
        for (Object o : v1) {
            System.out.println(o);
        }
        Enumeration  e1=v1.elements();
        while (e1.hasMoreElements())
        {
            System.out.println(e1.nextElement());
        }

    }
}
