package com.company;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String line = "foo,bar,c;qual=\"baz,blurb\",d;junk=\"quux,syzygy\"";
        String str="gopal,parmar\"gopal,parmar\",gopalparm";
        String[] tokens = str.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        for(String t : tokens) {
            System.out.println("> "+t);
        }
    }
}
