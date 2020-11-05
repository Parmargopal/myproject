package com.prominentpixel;

import java.util.Comparator;

public class KeyComparator implements Comparator<Student> {

    @Override
    public int compare(Student student, Student t1) {
        return student.getName().compareTo(t1.getName());
    }
}

