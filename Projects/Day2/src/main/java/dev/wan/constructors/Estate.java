package dev.wan.constructors;

public class Estate extends House{
    int gardensize;
    // SUPER ALWAYS HAS TO BE FIRST LINE IN CONSTRUCTOR
    Estate(String owner, int area, int walls, int gardensize){
        super(owner, area, walls);
        this.gardensize = gardensize;
    }
}
