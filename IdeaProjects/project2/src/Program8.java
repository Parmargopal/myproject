import com.sun.source.doctree.SummaryTree;

import java.util.Scanner;

public class Program8 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("enter X element=");
        int x=s.nextInt();
        System.out.print("enter Y element=");
        int y=s.nextInt();
        System.out.print("enter power N element=");
        int n=s.nextInt();
        double sum=0;

            for (int i=1;i<=n;i++)
            {
                sum=sum+(Math.pow(x,i)/Math.pow(y,i));

            }
        System.out.println(sum);
    }
}
