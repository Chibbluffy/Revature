package dev.wan.exceptionsfun;

// Checked exception
// Any method that throws this exception, MUST catch it or it will NOT compile
//
public class InvalidUsernameNormalException extends Exception{
    InvalidUsernameNormalException(String message){
        super(message);
    }
}
