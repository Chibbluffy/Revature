package dev.wan.overloading;

public class OverloadPlayground {
    public static void main(String[] args) {
        //Overloading is when a class has multiple methods of same name
        //Methods have different params
        //Allows devs to more succinctly name methods

        double sum = OverloadPlayground.add(1,2);

        // static polymorphism == overloading

        double [] nums = {1,2,3,4.44};
        double sum2 = sum(nums);
    }
    static double add(double a, double b){
        return a+b;
    }
    static double add(String a, String b){
        double x = Double.parseDouble(a);
        double y = Double.parseDouble(b);
        return x+y;
    }
    static double sum(double[] ray){
        double sum = 0;
        for (int i = 0; i<ray.length-1; i++){
            sum = sum+ray[i];
        }
        return sum;
    }
}
