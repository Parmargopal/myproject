public class Program3 {
    public int giveHCF(int number1, int number2)
    {
        int a=number1;
        int b=number2;
        while(a!=b)
        {
            if (a>b)
            {
                a=a-b;

            }
            else
                {
                 b=b-a;
                }

        }
        return b;
    }

    public static void main(String[] args) {
        Program3 p3=new Program3();
        System.out.println( p3.giveHCF(12,15));
        System.out.println( p3.giveHCF(143,169));
        System.out.println( p3.giveHCF(30,165));

    }

}
