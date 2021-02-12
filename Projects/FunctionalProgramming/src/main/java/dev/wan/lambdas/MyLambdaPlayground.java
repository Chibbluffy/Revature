package dev.wan.lambdas;

public class MyLambdaPlayground {
    public static void main(String[] args) {
        MathOperation add = (double num1, double num2)->{
            return num1+num2;
        };
        MathOperation multiply = (double num1, double num2)->{
            return num1*num2;
        };
        double sum = add.compute(1.1, 2.2);
        System.out.println(sum);

        double product = multiply.compute(1.1, 2.2);
        System.out.println(product);
    }
}
