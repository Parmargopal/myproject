package com.prominentpixel;

import javafx.beans.binding.When;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public static void main(String[] args) throws IOException {
        List<String> files= Files.readAllLines(Paths.get("/home/pp-5/Downloads/ELK-20201022T063954Z-001/ELK/requirement-1-Lucene/df.csv"));
        files.remove(0);
        for (String s:files)
        {
            String[] data = s.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            System.out.println("date="+data[0]+" "+" title="+data[1]+" "+"content="+data[2]);

        }

    }
}
