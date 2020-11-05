public class java1 {
    int rollno;
    String name;
    static String school="kalindi";
    java1(int rollno,String name)
    {
        this.name=name;
        this.rollno=rollno;
    }
    void display()
    {
        System.out.println(rollno+" "+name+" "+school);
    }
}
class test{
    public static void main(String[] args) {
        java1 j1=new java1(101,"gopal");
        java1 j2=new java1(101,"parmar");
        j1.display();
        j2.display();
    }
}

