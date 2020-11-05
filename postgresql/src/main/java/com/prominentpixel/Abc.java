package com.prominentpixel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Abc {
    public static void main(String[] args) throws ParseException {
        int[] marks = { 125, 132, 95, 116, 110 };
        int value=marks[2];
        for (int mark:marks)
        {
            if (mark==value)
            {
                System.out.println("choos print="+mark);
            }
            else
            {
                System.out.println("other value="+mark);
            }

        }
    }
}
