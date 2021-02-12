package dev.wan.abstraction;

public class Duck extends Animal implements Flyable, Swimmable, Pettable{


    public Duck(int age) {
        super("Duck", age);
    }

    @Override
    void eat() {
        System.out.println("quacks for food");
    }

    @Override
    public void fly() {
        System.out.println("Flapps wingers.");
    }

    @Override
    public void swim() {
        System.out.println("Waddles");
    }
}
