public class re {
    static int g(int n)
    {
        if(n==1)
        {
            return 1;
        }
        else
        {
            return (n*g(n-1));
        }
    }

    public static void main(String args[])
    {
        System.out.println("factorial value = "+g(5));
    }
}
