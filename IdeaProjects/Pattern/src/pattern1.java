import javax.swing.*;
import java.util.Scanner;

public class pattern1 {
    public static void main(String[] args) {
        int i,j;

        Scanner s1=new Scanner(System.in);
        System.out.print("n=");
        int n=s1.nextInt();
        for (i = 0; i < n-1; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (i % 2 == 0)
                    System.out.print((n * (i)) + j + 1 + " ");
                else
                    System.out.print((n * (i + 1)) - j + " ");
            }
            System.out.print("\n");
        }
    }
}
