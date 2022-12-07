package org.example.exception;

public class InvalidException extends Exception{
    public InvalidException(String wrong_input) {
        super("invalid input");
    }

    public static void invalidInternationalCode() throws Exception {
        throw new Exception("Wrong International Code ");
    }
}
