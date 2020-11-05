package com.prominentpixel;

import java.util.*;
import java.util.Map.Entry;
public class Map {
    public static void main(String[] args) {
       HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("one","gopal");
        hashMap.put("two","nilesh");
        hashMap.put("three","jayal");
        hashMap.put("four","vishal k");
       List list=new ArrayList();
       for (Entry<String, String> sort:hashMap.entrySet())
       {
           list.add(sort.getValue());
       }
        System.out.println(list);
        Collections.sort(list, new Comparator<String>() {
            public int compare(String str, String str1) {
                return (str).compareTo(str1);
            }
        });
        System.out.println(list);
      LinkedHashMap<String, String> sortedMap = new LinkedHashMap<>();
        for (Object str : list)
        {
            for (Entry<String,String> entry:hashMap.entrySet())
               if (entry.getValue().equals(str))
                {
                    sortedMap.put(entry.getKey(), (String) str);
                }
        }
        System.out.println(sortedMap);
    }
}
