package dev.wan.funcollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListComparePlayground {
    public static void main(String[] args) {
//        List<Object> objectArrayList = new ArrayList<Object>();
        // in main code say what we want
        // do not need to know implementation

        List<Object> objectArrayList = ArrayFactory.createList(0);

        // Appending
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++){
            objectArrayList.add(new Object());
        }
        long end = System.nanoTime();
        System.out.println("Add at end: " + (end-start));


        // Get middle
        start = System.nanoTime();
        for (int i = 0; i < 100000; i++){
            objectArrayList.get(50_000);
        }
        end = System.nanoTime();
        System.out.println(end-start);
        System.out.println("Get Middle: " + (end-start));


        // Add at beginning
        start = System.nanoTime();
        for (int i = 0; i < 100000; i++){
            objectArrayList.add(0, new Object());
        }
        end = System.nanoTime();
        System.out.println("Add at beginning: " + (end-start));

        List<Object> objectLinkedList = new LinkedList<Object>();

        // Appending
         start = System.nanoTime();
        for (int i = 0; i < 100000; i++){
            objectLinkedList.add(new Object());
        }
         end = System.nanoTime();
        System.out.println("Add at end: " + (end-start));


        // Get middle
        start = System.nanoTime();
        for (int i = 0; i < 100000; i++){
            objectLinkedList.get(50_000);
        }
        end = System.nanoTime();
        System.out.println(end-start);
        System.out.println("Get Middle: " + (end-start));


        // Add at beginning
        start = System.nanoTime();
        for (int i = 0; i < 100000; i++){
            objectLinkedList.add(0, new Object());
        }
        end = System.nanoTime();
        System.out.println("Add at beginning: " + (end-start));
    }
}
