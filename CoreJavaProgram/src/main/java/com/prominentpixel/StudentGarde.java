package com.prominentpixel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentGarde {
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

        Map <String,List<String>> map=new HashMap<>();
        for (StudentData student:document)
        {
            if (map.containsKey(student.getCollege()))
            {

                List<String> grade=map.get(student.getCollege());
                grade.add(student.getGrade());
            }
            else
            {
                List<String> grade=new ArrayList<>();
                grade.add(student.getGrade());
                map.put(student.getCollege(), grade);
            }
        }
        System.out.println(map);
    }
}
