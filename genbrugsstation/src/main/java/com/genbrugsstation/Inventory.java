package com.genbrugsstation;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

class Inventory implements Serializable {
    //inventory er et HashMap med String som key og Integer som value, der
    //oversættes til et navn på det affald, der samles op og en tilhørende mængde.
    //addItem() tilføjer element og mængde
    //getItemAmount tjekker via key (navn på affald) om elementet eksisterer, returnerer 0 hvis ikke og value hvis den eksisterer
    //getTotalAmount() summerer alle values op, og returnerer summen
    //getItems() returnerer items

    private Map<String, Integer> items;

    public Inventory(){
        items = new HashMap<>();
    }

    public void addItem(String name, int amount) {

        items.put(name, getItemAmount(name) + amount);
    }

    public int getItemAmount(String name) {

        return (items.get(name) == null ? 0 : items.get(name));
    }

    public int getTotalAmount() {
        int n = 0;
        for (String name : items.keySet()) {
            n += getItemAmount(name);
        }
        return n;
    }

    public Map<String, Integer> getItems() {
        return items;
    }
}