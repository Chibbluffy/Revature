package dev.wan.overriding;

public class OverridePlayground {
    public static void main(String[] args) {
        CreditCard mine = new CreditCard("Tom", 0, 0);
        mine.makePurchase(1000);
        mine.displayStatus();

        PlatinumCard mine2 = new PlatinumCard("Tom", 0, 0);
        mine2.makePurchase(1000);
        mine2.displayStatus();

        //Even tho is declared as CC, it will use Plat card implementation
        CreditCard mine3 = new PlatinumCard("Tom", 0, 0);
        mine3.makePurchase(1000);
        mine3.displayStatus();

        // divorce the reference type from actual type of object
        // reference type says what methods you can use
        // actual type is final code that would actually be called
        // this is polymorphism where a single object could have multiple
    }
}
