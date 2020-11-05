public class student {
    int rollno;
    String name;
    student(int rollno,String name)
    {
        this.rollno=rollno;
        this.name=name;
    }
    void display()
    {
        System.out.println(rollno+" "+name);
    }

    public static void main(String[] args) {
        student s1=new student(101,"gopal");
        s1.display();
    }
}
