package dev.wan.objs;

public class ObjectPlayground {
    public static void main(String[] args) {
        //Every class in Java inherits from Object class
        //Anything you make can be Object
        Object a = "hello";
        Object b = 2;
        Object c = new Integer(3);
        Object [] d = {1,2,3,4};

        Student s = new Student("Tom", 20);
        System.out.println(s.toString());
        System.out.println(s);// same as above line.
        // Any object call in a print statement is called toString by default


    }
}
