package com.prominentpixel;

import java.util.Comparator;

public class CollegeComparator implements Comparator<Student> {
    @Override
    public int compare(Student student, Student student1) {

        return student.getCollage().compareTo(student1.getCollage());
    }
}
