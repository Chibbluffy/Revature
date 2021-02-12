package dev.wan.abstraction;

public class AnimalPlayground {
    public static void main(String[] args) {
//        Animal alan = new Animal("zombie", -3);

//        alan.eat();

        Bear b = new Bear(5);
        b.eat();

        Rabbit c = new Rabbit(20);
        c.eat();

        //abstract only makes it impossible to directly build a specific class
        //if you have an abstract class you can also optionally create abstract methods


        Duck d = new Duck(3);
        d.eat();
        d.fly();

        Eagle e = new Eagle(30);
        e.eat();
        e.fly();

        Animal f = new Eagle(2);
        f.eat();
//        f.fly(); // cannot fly, not FLYABLE

        Flyable g = new Duck(44);
//        g.eat(); // cannot EAT, not ANIMAL
        g.fly();

        if (g instanceof Pettable){
            System.out.println("Duck can be pet");
        }
    }
}
