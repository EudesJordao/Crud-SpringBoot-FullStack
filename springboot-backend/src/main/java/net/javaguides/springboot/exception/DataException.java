package net.javaguides.springboot.exception;

public class DataException extends RuntimeException{

	private static final long serialVersionUID = 1L;


    public DataException(String message){
        super(message);
    }
}