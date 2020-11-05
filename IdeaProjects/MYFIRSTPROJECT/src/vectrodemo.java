import java.util.Iterator;
import java.util.Vector;

public class vectrodemo {
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
    }
}
