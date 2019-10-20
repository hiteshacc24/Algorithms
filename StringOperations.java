package com.company;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Vector;
import java.util.*;
class Student{
    int rollno;
    String name;
    int age;
    Student(int rollno,String name,int age){
        this.rollno=rollno;
        this.name=name;
        this.age=age;
    }
}
public class StringOperations {
    public static void main(String[] args) {

      Comparator<String> c = new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
              return o1.length() - o2.length();
          }
      };
      PriorityQueue<String> p = new PriorityQueue<>(c);
      p.add("Hitesh");
      p.add("Nupur");
      p.add("Kshitiz");
      p.add("Sam");
      Iterator i = p.iterator();
      while(!p.isEmpty()) {
          System.out.println(p.poll());
      }
    }
}
