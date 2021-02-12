package dev.wan.strings;

public class StringPlayground {
    public static void main(String[] args) {
        String name = "Tom";

        int x = 100;
        int j = 100;

        // comparing strings
        // == does a value compare on primitives
        // === does a value and type compare on primitives
        // == does not work on objects bc they are different memory addresses

        Person p1 = new Person("Tom", 20);
        Person p2 = new Person("Tom", 20);
        System.out.println(p1==p2);

        String name1 = "Tom";
        String name2 = "Tom";
        System.out.println(name1==name2);
        //True because both are pointing to the same memory address.
        // Not because both are equal values
        // There is a String pool where all strings live.
        // Strings are immutable, cannot be changed after

    }
}
