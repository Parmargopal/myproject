package com.prominentpixel;

import java.util.Map;
import java.util.TreeMap;

public class TreeMAp {
    public static void main(String[] args) {
        StudentData s1=new StudentData(1,"gopal","gardi","First Class");
        StudentData s2=new StudentData(2,"abhay","gardi","Second Class");
        StudentData s3=new StudentData(3,"jayal","atmiya","Second Class");
        StudentData s4=new StudentData(4,"nilesh","atmiya","First Class");
        StudentData s5=new StudentData(5,"prashant","atmiya","First Class");
        StudentData s6=new StudentData(6,"vishal k","marwadi","Second Class");

        Map<String, StudentData> map=new TreeMap<>();
    //    Map<String,Student> map=new LinkedHashMap<>();
        map.put(s1.getName(),s1);
        map.put(s2.getName(),s2);
        map.put(s3.getName(),s3);
        map.put(s4.getName(),s4);
        map.put(s5.getName(),s5);
        map.put(s6.getName(),s6);
        System.out.println(map);
       System.out.println(map.keySet());
      
    }
}
