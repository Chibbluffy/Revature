package dev.wan.constructors;

public class ConstructorPlayground {
    public static void main(String[] args) {
        Dwelling d1 = new Dwelling();
        d1.owner = "Me";
        d1.area = 1;

        Dwelling d2 = new Dwelling("Not me", 2);
        House d3 = new House();
        Estate d4 = new Estate("Tom", 2, 3, 4);

    }
}
