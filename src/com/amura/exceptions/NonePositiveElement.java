package com.amura.exceptions;

public class NonePositiveElement extends Exception {
    @Override
    public String getMessage(){
        return "Given array does not contain any positive integer";
    }
}
