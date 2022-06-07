package main.exceptions;

public class OutOfQtyException extends Exception{
    public OutOfQtyException(String message){
        super(message);
    }
}
