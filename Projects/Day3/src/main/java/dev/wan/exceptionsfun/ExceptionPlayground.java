package dev.wan.exceptionsfun;

import java.util.Scanner;

public class ExceptionPlayground {
    public static void main(String[] args) {

        // create a username
        // 1. username must be 6+ char
        // 2. username cannot contain symbols


        Scanner scanner = new Scanner(System.in);// Used to read input from user
        System.out.println("Enter a username");
        String input = scanner.next();

        try {
            isValidUsername(input);
        }catch (InvalidUsernameException e){
            e.printStackTrace();
        }finally{
            System.out.println("welcome "+input);
        }

    }

    static boolean isValidUsername(String username){
        if (username.length()<6){
            throw new InvalidUsernameException("Username too short");
        }
        else if (username.contains("!") || username.contains("#")){
            throw new InvalidUsernameException("Username contains illegal characters");
        }
        return true;
    }

    // Any NON-RUNTIME exception must be declared as possibly thrown in the method signature
    // Checked exceptions force programmers to have to enforce and account for failure
    static boolean isValidUsername2 (String username)throws InvalidUsernameNormalException{
        if (username.length()<6){
            throw new InvalidUsernameNormalException("Username too short");
        }
        else if (username.contains("!") || username.contains("#")){
            throw new InvalidUsernameNormalException("Username contains illegal characters");
        }
        return true;
    }

}
