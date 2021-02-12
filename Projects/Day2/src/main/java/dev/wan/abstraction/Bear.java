package dev.wan.abstraction;

public class Bear extends Animal{

    Bear(int age){
        super("Bear", age);
    }

    @Override
    void eat(){
        System.out.println("Bear eats honey.");
    }
}
