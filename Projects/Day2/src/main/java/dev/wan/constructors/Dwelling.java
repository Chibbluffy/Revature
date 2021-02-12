package dev.wan.constructors;

public class Dwelling {
    String owner;
    int area;
    //if no constructor is defined, default one is used
    // Good practice is to always create an explicit constructor
    Dwelling(){
        System.out.println("no args");
    }
    Dwelling(String owner, int area){
        this.owner = owner;
        this.area = area;
        System.out.println("building with args");
    }
}
