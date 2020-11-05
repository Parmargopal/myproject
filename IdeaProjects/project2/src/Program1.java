import java.util.Scanner;

public class Program1 {
    double printSumOfSeries(int terms)
    {
        double n=terms;
        Scanner s1=new Scanner(System.in);
        System.out.println("enter value of x=");
        int x=s1.nextInt();
        double sum=0;

        for (int i=1;i<=n;i++)
        {
            sum=sum+(Math.pow(x,i)/factorial(i));
        }
        double add=1-sum;
        return add;
    }

    static int factorial(int i) {
            int f=1;
            for (int j=1;j<=i;j++)
            f =f*j;
            return f;
    }

    public static void main(String[] args) {
        Program1 p1=new Program1();
        System.out.println(p1.printSumOfSeries(3));

    }
}
