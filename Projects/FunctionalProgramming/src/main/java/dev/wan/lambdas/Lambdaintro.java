package dev.wan.lambdas;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Lambdaintro {
    public static void main(String[] args){
        Set<String> ssbuCharacters = new HashSet<>();
        ssbuCharacters.add("Samus");
        ssbuCharacters.add("Fox");
        ssbuCharacters.add("Link");
        ssbuCharacters.add("Pikachu");

        for (String name: ssbuCharacters){
            System.out.printf("A new challenger approaches "+name);
        }

        // Lambda is essentially code stored as a variable in Java
        // Storing a piece of code in variable
        Consumer<String> printName = (name) -> {
            System.out.println("A function approaches for "+name);
        };

        ssbuCharacters.forEach(printName);
    }
}
