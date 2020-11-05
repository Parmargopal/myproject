package com.prominentpixel;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class csvfile {
    public static void main(String[] args) throws IOException {
        File file=new File("/home/pp-5/Documents/a.csv");
        FileWriter writer=new FileWriter(file);
        CSVWriter csvWriter=new CSVWriter(writer);
        String[] header={"id","name","rollno"};
        csvWriter.writeNext(header);
        String[] value={"1","gopal","16cse073"};
        csvWriter.writeNext(value);
        String[] value1={"2","nilesh","16cse075"};
        csvWriter.writeNext(value1);
        csvWriter.close();
    }
}
