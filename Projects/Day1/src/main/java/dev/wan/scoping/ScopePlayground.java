package dev.wan.scoping;

public class ScopePlayground {
    public static void main(String [] args) {

        // new keyword is malloc
        Car mine = new Car("something", "plusplus", 20);

        Car his = new Car("Toyota", "Camry", 20000);

        mine.displayStatus();


        mine.drive(50);
        Car.kilos(50);


        // There are 4 scopes
        // NO GLOBAL SCOPE
        // 1. Static or class
        // 2. Instance or object
        // 3. Parameter or method
        // 4. Local

    }
}
