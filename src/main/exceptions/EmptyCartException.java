package main.exceptions;

public class EmptyCartException extends Exception{
    public EmptyCartException(String message) {
        super(message);
    }
}
