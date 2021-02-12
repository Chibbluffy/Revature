package dev.wan.overriding;

public class CreditCard {
    String owner;
    double balance;
    double rewardPoints;

    CreditCard(String owner, double balance, double rewardPoints){
        this.owner = owner;
        this.balance = balance;
        this.rewardPoints = rewardPoints;
    }

    //Create/make purchase, increase balance and reward points
    void makePurchase(double price){
        this.balance = this.balance + price;
        this.rewardPoints = this.rewardPoints + (price * .01);
    }
    void displayStatus(){
        System.out.println("Balance: " + this.balance);
        System.out.println("Points: " + this.rewardPoints);
    }
}
