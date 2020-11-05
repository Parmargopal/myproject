package com.prominentpixel;

import java.util.Comparator;

public class NameComparator  implements Comparator<Student> {

    @Override
    public int compare(Student student, Student student1) {

        Student std=(Student)student;
        Student std1=(Student)student1;
        if (std.getName()==std1.getName())
        {
            return std.getCollage().compareTo(std1.getCollage());
        }
        else
        {
            return std.getName().compareTo(std1.getName());
        }

    }
}
