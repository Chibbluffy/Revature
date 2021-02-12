package dev.wan.b;

import dev.wan.a.Shape;

public class BPlayground {
    public static void main(String[] args) {
        Shape s = new Shape();
        s.pubMeth();

        // NOT AVAILABLE BC NOT IN PACKAGE OR CLASS
//        s.defMeth();
//        s.proMeth();
//        s.privMeth();
        Circle c = new Circle();
        c.pubMeth();
//        s.defMeth();
//        s.proMeth();
//        s.privMeth();
        c.meth();


    }
}
