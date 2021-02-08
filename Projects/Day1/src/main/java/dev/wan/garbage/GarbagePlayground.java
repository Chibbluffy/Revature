package dev.wan.garbage;

public class GarbagePlayground {
    public static void main (String [] args) {
        poop mine = new poop();
        mine.color = "brown";
        mine.consistency = "solid";

        poop yours = new poop();
        yours.color = "red";
        yours.consistency = "wet";

        System.out.println(mine.color);
        System.out.println(mine.consistency);

        mine = null;
        yours = null;
        System.gc(); // directly calls garbage collection
    }
}
