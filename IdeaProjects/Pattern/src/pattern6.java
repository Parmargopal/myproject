public class pattern6 {
    public static void main(String[] args) {
        int i,j;
        for (i=1;i<=5;i++)
        {
            for (int k=5;k>i;k--)
            {
                System.out.print(" ");
            }
            for (j=i;j>=1;j--)
            {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
