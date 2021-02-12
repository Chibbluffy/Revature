package dev.wan.tdd;

// You are tasked with creating a calculator that can perform certain geometric calculations
// TDD
// 1. write an interface clearly defining methods
// 2. write tests to verify any implementation written is correct
// 3. Write implementation
public interface GeometryCalculator {
    double areaSquare(double length);
    double areaCircle(double radius);
    double distance(double x1, double y1, double x2, double y2);

}
