package com.prominentpixel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
            StudentData s1=new StudentData(1,"gopal","gardi","First Class");
            StudentData s2=new StudentData(2,"abhay","gardi","Second Class");
            StudentData s3=new StudentData(3,"jayal","atmiya","Second Class");
            StudentData s4=new StudentData(4,"nilesh","atmiya","First Class");
            StudentData s5=new StudentData(5,"vishal k","marwadi","Second Class");
            List<StudentData> document=new ArrayList<>();
            document.add(s1);
            document.add(s2);
            document.add(s3);
            document.add(s4);
            document.add(s5);
            System.out.println(document);
            System.out.println("Sorting with name");
            Collections.sort(document,new Name());
            for (StudentData st:document)
            {
                    System.out.println(st.getId()+" "+st.getName()+" "+st.getCollege()+" "+st.getGrade());
            }
            System.out.println();
            System.out.println("Sorting with Collage");

            Collections.sort(document,new College());
            for (StudentData st:document)
            {
                    System.out.println(st.getId()+" "+st.getName()+" "+st.getCollege()+" "+st.getGrade());
            }
        }
}

