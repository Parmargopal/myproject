import java.util.Scanner;

public class Program6 {
    public static void main(String[] args) {
        Scanner S1=new Scanner(System.in);
        System.out.print("enter A element=");
        int a=S1.nextInt();
        System.out.print("enter R element=");
        int r=S1.nextInt();
        System.out.print("enter power N element=");
        int n=S1.nextInt();
        double sum=0;
        for (int i=0;i<=n;i++)
        {
            sum=sum+a*(Math.pow(r,i));
        }
        System.out.println(sum);
    }
}
