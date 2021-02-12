package dev.wan.exceptionsfun;

public class InvalidUsernameException extends RuntimeException{
    InvalidUsernameException(String message){
        super(message);
    }
}
