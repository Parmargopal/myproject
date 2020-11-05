package com.prominentpixel;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dates {
    public static void main(String[] args) throws ParseException {
        String string="21/01/2020";
        Date date = new Date(string);
        String pattern="yyyy/MM/dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String dates=dateFormat.format(date);
        System.out.println("Date : "+dates);
    }
}
