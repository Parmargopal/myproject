public class Program2 {
    int giveLCM(int number1, int number2)

    {
        //find HCM
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

        //find Lcm using formula
        int x=number1;
        int y=number2;
        int l=b;
        int lcm=(x*y)/l;

        return lcm;

    }
    public static void main(String[] args) {
        Program2 p2=new Program2();
        System.out.println(p2.giveLCM(12,15));
        System.out.println(p2.giveLCM(21,36));
        System.out.println(p2.giveLCM(6,39));

    }
}
