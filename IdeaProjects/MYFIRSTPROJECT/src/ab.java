abstract class ab {
    abstract void m1();
    void m2()
    {
        System.out.println("gopal");
    }
}
class bc extends ab
{
    void m1()
    {
        System.out.println("parmar");
    }
}
class cd
{
    public static void main(String[] args) {
        bc b1=new bc();
        b1.m2();
        b1.m1();

    }
}
