package dev.wan.abstraction;

public class Eagle extends Animal implements Flyable{

    public Eagle(int age) {
        super("Eagle", age);
    }

    @Override
    void eat() {
        System.out.println("swoops down on you");
    }


    @Override
    public void fly(){
        System.out.println("flies like an eagle.");
    }
}
