package com.prominentpixel;

import java.util.*;
import java.util.Map;

public class HAshMap {
    public static void main(String[] args) {
        Student s1=new Student(1,"gopal","gardi","A");
        Student s2=new Student(2,"abhay","gardi","A+");
        Student s3=new Student(3,"jayal","atmiya","B");
        Student s4=new Student(4,"nilesh","marwadi","B+");
        Student s5=new Student(5,"vishal k","marwadi","B-");
        Student s6=new Student(6,"Harshit","vvp","C");
        Student s7=new Student(7,"prashant","vvp","C+");
        Student s8=new Student(8,"Vaibhav","labhuben","A");
        Student s9=new Student(9,"Vishal h","labhuben","B");
        Student s10=new Student(10,"Divyesh","GEC","A");
        Map<String,Student> map=new HashMap<>();
        map.put(s1.getName(),s1);
        map.put(s2.getName(),s2);
        map.put(s3.getName(),s3);
        map.put(s4.getName(),s4);
        map.put(s5.getName(),s5);
        map.put(s6.getName(),s6);
        map.put(s7.getName(),s7);
        map.put(s8.getName(),s8);
        map.put(s9.getName(),s9);
        map.put(s10.getName(),s10);
        System.out.println(map);
       List list=new ArrayList();
       for (Map.Entry<String, Student> data:map.entrySet())
       {
           list.add(data);
       }
        System.out.println(list);

        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                return ((Comparable)((Map.Entry) (o)).getKey()).compareTo(((Map.Entry) (t1)).getKey());
            }
        });
        System.out.println(list);
        LinkedHashMap<String, String> sortedMap = new LinkedHashMap<>();
        for (Object str : list)
        {
            for (Map.Entry<String,Student> entry:map.entrySet())
               if (entry.getValue().equals(str))
                {
                    sortedMap.put(entry.getKey(), (String) str);
                }
        }
        System.out.println(sortedMap);
    }
    }

