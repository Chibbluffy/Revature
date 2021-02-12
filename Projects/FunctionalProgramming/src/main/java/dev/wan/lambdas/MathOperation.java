package dev.wan.lambdas;

// To write a lambda you make an interface with one and ONLY one abstract method
@FunctionalInterface // enforces that this interface is used to make lambdas
// Prevents you from adding more than one abstract method
public interface MathOperation {
    double compute(double num1, double num2);
}
