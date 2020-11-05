import java.util.Scanner;
import java.lang.Math;

public class Program7 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("enter X element number=");
        int x=s.nextInt();
        System.out.print("enter N element number=");
        int n=s.nextInt();
        double sum=0;
        for (int i=1;i<=n;i++)
        {
            sum= sum+Math.pow(x,i);
        }
        System.out.println(sum);

    }
}
