package org.example.exception;

public class NullpointerExeption extends Exception{
    //section null pointer Exeption
    public static void nullPointerExeption() throws NullPointerException, NullpointerExeption {
        throw new NullpointerExeption();
    }
}
