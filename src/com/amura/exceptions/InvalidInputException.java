package com.amura.exceptions;

public class InvalidInputException extends Exception {
    @Override
    public  String getMessage(){
        return ("Invalid array");
    }
}
