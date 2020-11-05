package com.prominentpixel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeCount {
    public static void main(String[] args) {
        StudentData s1=new StudentData(1,"gopal","gardi","First Class");
        StudentData s2=new StudentData(2,"abhay","gardi","Second Class");
        StudentData s3=new StudentData(3,"jayal","atmiya","Second Class");
        StudentData s4=new StudentData(4,"nilesh","atmiya","First Class");
        StudentData s5=new StudentData(5,"prashant","atmiya","First Class");
        StudentData s6=new StudentData(6,"vishal k","marwadi","Second Class");
        List<StudentData> document=new ArrayList<>();
        document.add(s1);
        document.add(s2);
        document.add(s3);
        document.add(s4);
        document.add(s5);
        document.add(s6);

        Map<String, Map<String, Integer>> map = new HashMap<>();
        int num = 1;
        for (StudentData student : document) {
            if (map.containsKey(student.getCollege())) {
                Map<String, Integer> grade = map.get(student.getCollege());

                if (grade.containsKey(student.getGrade())) {
                    grade.replace(student.getGrade(), ++num);
                } else {
                    grade.put(student.getGrade(), 1);
                }
            }
            else {
                Map<String, Integer> gradeMap = new HashMap<>();
                if (student.getGrade() == "First Class") {
                    gradeMap.put("First Class", 1);
                } else {
                    gradeMap.put("Second Class", 1);
                }

                map.put(student.getCollege(), gradeMap);
            }
        }
        System.out.println(map);

    }
}
