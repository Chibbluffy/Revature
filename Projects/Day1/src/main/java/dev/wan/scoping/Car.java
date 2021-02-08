package dev.wan.scoping;


// Class vs Object
// Class is blueprint of obj, Obj is instance of class
// method is a function attached to an object
public class Car {

    // instance vars
    String make;
    String model;
    int mileage;
    // method
    void displayStatus(){
        System.out.println(this.make + " : " + this.model);
        System.out.println("Mileage: " + this.mileage);
    }
    void drive(int miles){
        System.out.println("Driving");
        this.mileage += miles;
    }

    // Static variables are only one copy of can exist
    // does not belong to an object, belongs to class as a whole
    // can change
    // attached directly to class
    static int statNum = 100;
    // static methods do not belong attached to object
    // should be independent or attached to class itself
    // impossible to use "this" in a static method
    static void hello(){
        System.out.println("Hello");
    }
    static void kilos(int miles){
        System.out.println("Kilos: " + miles*.6);
    }
    //if function does not look at or modify instance variable,
    // it could prob be static


    // Constructor, creates instance of class
    // must be same name as class, no return type
    Car(String make, String model, int mileage) {
        System.out.println("Creating car");
        this.make = make;
        this.model = model;
        this.mileage = mileage;
    }

    // static refers to this var memory address never changes,
    // so there can only be one of that variable.
}
