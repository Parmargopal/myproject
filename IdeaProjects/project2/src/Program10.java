import java.util.Scanner;

public class Program10 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("enter number =");
        int n=s.nextInt();

        for (int i=1;i<=n;i++)
        {
            int temp=0;
            for (int j=2;j<i;j++)
            {
                if(i%j==0)
                {
                    temp=temp+1;
                }

            }
            if (temp==0)
            {
                System.out.println(i);
            }
        }
    }
}
