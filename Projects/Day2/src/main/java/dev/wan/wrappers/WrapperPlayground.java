package dev.wan.wrappers;

public class WrapperPlayground {
    public static void main(String[] args) {
        //Wrapper classes
        // Object versions of primitives
        // Can be helpful for certain OOP situations/utilities

        int i = 100;
        Integer ii = 100;

        // Allows access to Integer CLASS
        ii.byteValue();

        Boolean b = false;
        Short s = 10;
        //Long o = 100;
        Double d = 10.2;
        Byte B = 10;
        Character c = 'v';
        Float f = 20.5f;

        long start = System.nanoTime();
        for (int x = 0; x<1000; x++){
            Integer a = 100;
        }
        long end = System.nanoTime();
        // It is 100x slower to create the Wrapper class of a primitive
        // Bc it has to make the entire object and all the pointers
        System.out.println(end-start);


        //unboxing  wrapper -> primitive
        Integer int1 = 3;
        Integer int2 = 4;
        add(int1, int2);

        //autoboxing  primitive -> wrapper
        int m = 9;
        int n = 7;
        subtract(m,n);



        // There is an integer pool
        // for integers under 128, the integers are the same memory address
        // for integers over 127, the integers are different memory address
        Integer aa = 100;
        Integer bb = 100;
        System.out.println(aa==bb);// true
        Integer cc = 1000;
        Integer dd = 1000;
        System.out.println(cc==dd);// false

        //Wrappers: One of the few objects that can be created with a literal object

    }

    static int add(int a, int b){
        return a+b;
    }
    static int subtract(Integer a, Integer b){
        return a-b;
    }
}
