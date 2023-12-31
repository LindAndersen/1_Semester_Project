package com.genbrugsstation;

import java.io.Serializable;
import java.util.Random;

class Trash implements Serializable {
    private String name;
    private double modifier = 1;
    private int amount;

    Trash(String name) {
        this.name = name;
        setTrash();
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    //Instead of printing not enough trash, we throw custom made exception "InsufficientTrashException"
    //This exception is caught in Space
    void subtractTrash(int amount) throws InsufficientTrashException {
        if (this.amount < amount) { 
            throw new InsufficientTrashException("Du kan ikke samle så meget skrald op af denne type");
        }
        this.amount -= amount;
        
    }

    public void setTrash() {
        Random rand = new Random();
        int randInt = rand.nextInt(10);

        //First we convert randInt to a double to multiply with double modifier, then back to int
        amount = (int) ((double) randInt * modifier);
    }
}