package com.prominentpixel;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorProgram {
    public static void main(String[] args) {
        Vector vector=new Vector();
        vector.add("gopal");
        vector.add("jayal");
        vector.add("nilesh");
        vector.add("vishal");
        vector.add("harshit");
        vector.addElement("vishal h");
        vector.addElement("prashant");
        vector.addElement("vaibhav");
        System.out.println(vector);
        //define vector with intialcapacity
        Vector vector1=new Vector(5);
        System.out.println(vector1.capacity());
        vector1.add("gopal");
        vector1.add("jayal");
        vector1.add("nilesh");
        vector1.add("vishal");
        vector1.add("harshit");
        vector1.add("sagar");
        System.out.println(vector1);
        System.out.println(vector1.capacity());
        Iterator iterator= vector1.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        //define vector with intialcapacity and capacityIncrement
        Vector vector2=new Vector(5,2);
        System.out.println(vector2.capacity());
        vector2.add("gopal");
        vector2.add("jayal");
        vector2.add("nilesh");
        vector2.add("vishal");
        vector2.add("harshit");
        vector2.add("sagar");
        System.out.println(vector2);
        System.out.println(vector2.capacity());
        //Enumeration Interface use for Traverser and Enumeration Interface use for only legacy collection
        Enumeration enumeration= vector2.elements();
        while (enumeration.hasMoreElements())
        {
            System.out.println(enumeration.nextElement());
        }

    }
}
