package com.prominentpixel;

import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        StudentData s1=new StudentData(1,"gopal","gardi","First Class");
        StudentData s2=new StudentData(2,"abhay","gardi","Second Class");
        StudentData s3=new StudentData(3,"gopal","atmiya","Second Class");
        StudentData s4=new StudentData(4,"nilesh","atmiya","First Class");
        StudentData s5=new StudentData(5,"vishal k","marwadi","Second Class");
        List<StudentData> document=new ArrayList<>();
        document.add(s1);
        document.add(s2);
        document.add(s3);
        document.add(s4);
        document.add(s5);
        Map<String, List<StudentData>> studentName = new LinkedHashMap<>();

        for (StudentData student : document) {
            if (studentName.containsKey(student.getCollege())) {
                List<StudentData> names = studentName.get(student.getCollege());
                names.add(student);
            }
            else {
                List<StudentData> studentNames = new ArrayList<>();
                studentNames.add(student);
                studentName.put(student.getCollege(), studentNames);
            }
        }
        System.out.println(studentName);
    }
    }

