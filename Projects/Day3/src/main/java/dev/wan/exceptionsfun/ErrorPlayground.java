package dev.wan.exceptionsfun;

public class ErrorPlayground {
    static int counter;
    public static void main(String[] args) {
        // Stack overflow error
        // Out of memory error
        // etc

        try{
            overflow();
        }catch (Error e){
            System.out.println("Error"+counter);
        }
        // NEVER catch errors, it is bad to do that
        // Errors are for things that are unrecoverable. Require you to rewrite the code.
        // Errors should NOT be handled

    }
    static void overflow(){
        counter++;
        overflow();
    }
}
