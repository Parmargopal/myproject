import java.util.Scanner;

public class Program9 {
    public static void main(String[] args) {
        Scanner s1=new Scanner(System.in);
        System.out.print("enter sum of 1ton element =");
        int a=s1.nextInt();
        System.out.print("enter power N element=");
        int n=s1.nextInt();
        int sum=0;
        double add=0;
        for (int i=1;i<=n;i++)
        {
                sum=sum+i;
                add=add+(sum)*(Math.pow(3,i));
        }
        System.out.println(add);
    }
}

