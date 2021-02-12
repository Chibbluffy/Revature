package dev.wan.app;

public class App {
    public static void main(String[] args) {

        // Thread is a path of execution of through a program/code
        // Java is multi threaded language
        // Can run multiple different pieces of code at same time

        //lambda you are defining block of code
        Runnable process1 = () -> {
            System.out.println(Thread.currentThread());
            System.out.println("Hi");
        };

        // Thread class in java is used to create threads
        Thread t1 = new Thread(process1);
        Thread t2 = new Thread(process1);
        Thread t3 = new Thread(process1);


        // Starts a new thread
        t1.start();
        t2.start();
        t3.start();

        // executes code on the current thread
        t1.run();
        t2.run();
        t3.run();


        System.out.println(Thread.currentThread());
    }
}
