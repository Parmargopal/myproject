package com.prominentpixel;

import java.util.Hashtable;
import java.util.Map;

public class HashTable {
    public static void main(String[] args) {
        Hashtable<Integer,String> hashtable=new Hashtable<>();
        hashtable.put(100,"gopal");
        hashtable.put(101,"abhay");
        hashtable.put(103,"vishal");
        hashtable.put(102,"nilesh");
        System.out.println(hashtable.hashCode());
        System.out.println(hashtable);
        System.out.println(hashtable);

        for(Map.Entry s:hashtable.entrySet())
        {
            System.out.println(s.getKey()+" "+s.getValue());
        }
    }
}
