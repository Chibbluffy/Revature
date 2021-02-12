package dev.wan.funcollections;

public class Player {
    String name;
    int height;

    public Player(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
