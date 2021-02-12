package dev.wan.a;

public class APlayground {
    public static void main(String[] args) {
        Shape s = new Shape();
        s.pubMeth();
        s.defMeth();
        s.proMeth();

        // s.privMeth(); // NOT CALLABLE BC NOT IN THAT CLASS RN

        // Can never use access modifiers WITHIN a method

        // Access modifiers are to hide info and methods.
        // Protecting them from incorrect use
    }
}
