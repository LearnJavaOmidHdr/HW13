package org.example.exception;

public class UserNotFound extends RuntimeException{
    public UserNotFound() {
        super("wrong Username And Password");
    }
}
