package com.prominentpixel;

public class Student implements Comparable {
    private int id;
    private String name;
    private String collage;
    private String grade;

    public Student(int id, String name, String collage, String grade) {
        this.id = id;
        this.name = name;
        this.collage = collage;
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

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String toString()
    {
        return id +" "+name+" "+collage+" "+grade;
    }

    @Override
    public int compareTo(Object o) {
        Student student=(Student)o;
        return this.getName().compareTo(student.getName());
    }
}
