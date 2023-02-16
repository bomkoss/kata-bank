package com.diihuman.exceptions;

public class InconsistentAmount extends RuntimeException{
    public InconsistentAmount(String message) {
        super(message);
    }
}
