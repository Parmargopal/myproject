import java.util.Scanner;

public class pattern9 {
    public static void main(String[] args) {
        int i,j;
        Scanner s1=new Scanner(System.in);
        System.out.print("enter element=");

        int n=s1.nextInt();
        for (i=1;i<=n;i++)
        {
            for (j=1;j<=n;j++)

            {
                if (i==1 ||j==1 || i==n ||j==n )
                {
                    System.out.print(1 + " ");
                }
                else
                {
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
    }
}
