package dev.wan.Cars;

public class Car {
    private String make;
    private String model;
    private int mileage;

    // Encapsulation can be used to protect data,
    // prevent it from having values that do not make sense
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        this.mileage = 0;
    }

    public void drive(int miles){
        this.mileage = this.mileage + miles;
        System.out.println("drives "+miles+" miles");
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                '}';
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMileage(int mileage) {
        if (mileage < 0){
            return;
        }
        this.mileage = mileage;
    }
}
