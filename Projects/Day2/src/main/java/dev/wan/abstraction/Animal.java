package dev.wan.abstraction;

public abstract class Animal {
    String species;
    int age;

    public Animal(String species, int age) {
        this.species = species;
        this.age = age;
    }

    public Animal(){
        this.species = "0";
        this.age = 1;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", age=" + age +
                '}';
    }

    void eat(){
        System.out.println(this.species + " eats food.");
    }
}
