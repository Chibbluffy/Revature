package dev.wan.funcollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Factory design pattern is when we have a method that returns an implementation of an interface
// Tell factory what we want. Do not care what specific implementation we receive
// helps build large scalable applications by subtracting implementation details
// CODE TO INTERFACES
public class ArrayFactory {

    // input 0 to get arraylist
    // input any other num to get linkedlist
    static List createList(int choice){
        if (choice == 0){
            return new ArrayList();
        }
        else{
            return new LinkedList();
        }
    }
}
