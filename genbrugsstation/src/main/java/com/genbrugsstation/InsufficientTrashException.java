package com.genbrugsstation;

public class InsufficientTrashException extends Exception {
    InsufficientTrashException(String s) {
        super(s);
    }
}