package com.prominentpixel;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;


public class LinkedListProgram {
    public static void main(String[] args) {
       LinkedList<String> list = new LinkedList<String>();
        list.add("gopal");
        list.add("nilesh");
        list.add("abhay");
        list.add("vishal");
        list.add("jayal");
    LinkedList<String> list1 = new LinkedList<String>();
        list1.addAll(list);
        list1.add("prashant");
        list1.add("vaibhav");
        list1.add("vishal h");
        list1.add("harshit");

        //use iterator interface using for traverser
        Iterator iterator=list1.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
       //list Iterator is used for forward and backword traverser
        System.out.println("forward ListIterator");
        ListIterator iterator1=list1.listIterator();
        while (iterator1.hasNext())
        {
            System.out.println(iterator1.next());
        }
        System.out.println(" backward ListIterator");
        while (iterator1.hasPrevious())
        {
            System.out.println(iterator1.previous());
        }



        //Linkedlist as a stack
      LinkedList list2 = new LinkedList();
        list2.push("bahrgav");
        list2.push("ashish");
        list2.push("chauhan");
        list2.push("sagar");
        list2.pop();
        System.out.println(list2);

        //LinkedList as a queue
        LinkedList<String> list3 = new LinkedList<String>(list1);
        list3.addFirst("milan");
        list3.addLast("jigar");
        list3.add(3,"yash");
        System.out.println(list3);
        System.out.println(list3.get(2));

    }
}
