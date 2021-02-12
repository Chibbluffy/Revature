package dev.wan.a;

public class Shape {
    // Java has access modifiers
    //   limit where a variable can be seen
    //   NOT SCOPES
    // public, default, protected, private
    //

    // This can be called anywhere in application
    public void pubMeth(){
        System.out.println("Public method");
    }
    // This can be seen ONLY within this package
    // AND any class that inherits from this class (children)
    protected void proMeth(){
        System.out.println("Protected method");
    }
    // This can only be called in this package (PACKAGE A)
    void defMeth(){
        System.out.println("Default method");
    }
    // This can be called only be seen and accessed within this class
    private void privMeth(){
        System.out.println("Private method");
    }
    // can use any of the methods from within same class
    void otherMeth(){
        this.pubMeth();
        this.proMeth();
        this.privMeth();
        this.defMeth();
    }
}
