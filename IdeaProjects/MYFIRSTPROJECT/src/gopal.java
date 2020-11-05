import javax.swing.*;
import java.util.function.DoubleToIntFunction;

public class gopal {
    static String name="abcd";
    static void dog()
    {
        name="abc";
    }
    void display()
    {
        System.out.println(name);
    }

    public static void main(String[] args)
    {
        dog();
    }
}
