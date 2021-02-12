package dev.wan.Cars;

public class CarPlayground {
    public static void main(String[] args) {
        Car c = new Car("Toyota", "Versa");
        c.drive(5);
        System.out.println(c);

        // Cannot access c.make, c.model, c.mileage
        // Can only do so with getters and setters
    }
}
