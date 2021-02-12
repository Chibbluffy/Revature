package dev.wan.exceptionsfun;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonExceptionsPlayground {

    // Exceptions occur when something fails or does not go as expected/intended
    // Exceptions should be recoverable
    // Defensive programming
    // If something goes wrong you should try to respond to it
    public static void main(String[] args) {
        // Exceptions are objects
        // Can be thrown. "Throwable object"
        // Tells what went wrong and where
        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("Add 2 nums");
//            System.out.println("First num:");
//            int num1 = scan.nextInt();
//            System.out.println("Second num:");
//            int num2 = scan.nextInt();
//            System.out.println("Sum: " + (num1 + num2));
            InputMismatchException ex = new InputMismatchException();
            throw ex;
        }
        catch (InputMismatchException e) {
            System.err.println("Not a valid number o no");
            e.printStackTrace();
            System.out.println(e);

        }

        // Common exceptions
        // InputMismatch: expected one type but got another
        // IllegalArgument: method expected one type but got another
        // ArrayIndexOutOfBounds: access element that does not exist
        // NullPointer: call method or access a field on null object
        catch (ArithmeticException e){
            System.err.println("Math wrong");
            e.printStackTrace();
            System.err.println(e);
        }
        catch (InvalidUsernameException e){
            System.err.println("Bad Username");
            e.printStackTrace();
            System.err.println(e);
        }
        finally {
            System.out.println("poopoopeepee");
        }
    }

}
