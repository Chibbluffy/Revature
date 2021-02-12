package dev.wan.abstraction;

public class Rabbit extends Animal{

    Rabbit(int age){
        super("Rabbit", age);
    }

    @Override
    void eat(){
        System.out.println("Munches on carrots.");
    }
}
