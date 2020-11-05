package com.prominentpixel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountCollage {
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

        Map<String, Integer> map = new HashMap<>();
            for (StudentData student : document) {
                if (map.containsKey(student.getCollege())) {
                    int num = map.get(student.getCollege());
                    num=num+1;
                       map.replace(student.getCollege(), num);
                } else {
                    map.put(student.getCollege(), 1);
                }

            }
        System.out.println(map);
        }
    }

