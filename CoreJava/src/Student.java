import java.util.Comparator;

public class Student {
    private int id;
    private String name;
    private  String college;
    private String grade;

    public Student(int id, String name, String college, String grade) {
        this.id = id;
        this.name = name;
        this.college = college;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    @Override
    public String toString()
    {
        return id +" "+name+" "+" "+college+" "+grade;
    }

}
class Name implements Comparator
{

    @Override
    public int compare(Object o, Object o1) {
        Student st1=(Student)o;
        Student st2=(Student)o1;
        return st1.getCollege().compareTo(st2.getName());
    }
}
