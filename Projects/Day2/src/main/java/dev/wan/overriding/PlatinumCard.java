package dev.wan.overriding;

public class PlatinumCard extends CreditCard{
    double flyerPoints;
    //Inheritance
    // Platinum card is at this point the exact same as Credit card
    PlatinumCard(String owner, double balance, double rewardPoints){
        super(owner, balance, rewardPoints);
    }

    //Overriding
    // Child class using same method signature has diff implementation
    // This is dynamic polymorphism == overriding
    // Java does not know what it will be using for the method
    @Override
    void makePurchase(double price){
        this.balance = this.balance + price;
        this.rewardPoints = this.rewardPoints + (price * .02);
        this.addFlyerMiles(5);
    }

    void addFlyerMiles(double points){
        this.flyerPoints = this.flyerPoints + points;
    }
}
