package com.prominentpixel;

import java.util.HashMap;
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        HashMap <String,String> map=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter record:");
        int n= sc.nextInt();
        for (int i=0;i<=n;i++)
        {
            System.out.println("enter key:");
            String key=sc.next();
            System.out.println("enter value:");
            String value=sc.next();
            map.put(key,value);
        }
        System.out.println(map);

    }

}
