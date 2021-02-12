package dev.wan.app;

public class App {
    // Thread is an

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
