package dev.wan.constructors;

public class House extends Dwelling{

    int walls;
    // Java does this automatically, adds a super constructor if nothing there
    House() {
        // SUPER ALWAYS HAS TO BE FIRST LINE IN CONSTRUCTOR
        super();
        this.walls = 4;
        System.out.println("no args house constructor");
    }

    House(String owner, int area, int walls){
        super(owner, area);
        this.walls = walls;
        System.out.println("building house with walls");
    }
}
