package com.genbrugsstation;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

class Inventory implements Serializable {
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

    @Override
    public String toString() {

        return "Not implemented";
    }
}