package dev.wan.strings;

public class StringBuilderPlayground {
    public static void main(String[] args) {
        //StringBuilder is designed for string manipulation
        StringBuilder sb1 = new StringBuilder("Hello");
        String s1 = "hi";
        for (int i = 0; i < 10000; i++){
            sb1.append("a");//directly adds to string builder
            s1.concat("b");//returns new string
        }
        System.out.println(sb1);
        System.out.println(s1);
        //It is about 10x faster to do StringBuilder than do String manipulation
    }
}
