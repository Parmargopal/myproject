import java.util.Scanner;

public class Program4 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("enter element of a=");
        int a=s.nextInt();
        System.out.print("enter element of b=");
        int b=s.nextInt();
        System.out.print("enter element of c=");
        int c=s.nextInt();
        double D=Math.pow(b,2)-(4*a*c);
        System.out.println(D);
    }
}
