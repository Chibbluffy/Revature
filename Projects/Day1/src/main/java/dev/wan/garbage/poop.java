package dev.wan.garbage;

public class poop {
    String color;
    String consistency;


    @Override
    public void finalize(){
        System.out.printf("Deleting poop. It was " + this.color);
    }


}
