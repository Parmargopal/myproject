public class SCHHOLDATA {
    int rollno;
    String name;
     String schooln="kalindi";
public SCHHOLDATA(int rollno,String name)
    {
        this.rollno=rollno;
        this.name=name;
    }
    void display()
    {
        System.out.println(rollno+" "+name+" "+schooln);
    }

}
 class run{
    public static void main(String[] args) {
        SCHHOLDATA s1=new SCHHOLDATA(101,"abc");
        SCHHOLDATA s2=new SCHHOLDATA(102,"xyz");
        s1.display();
        s2.display();
    }
}

