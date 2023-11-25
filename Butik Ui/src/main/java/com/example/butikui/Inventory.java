package com.example.butikui;

import java.util.HashMap;
import java.util.Map;

class Inventory {
    private Map<String, Integer> items;

    public Inventory(){
        items = new HashMap<String, Integer>();
    }

    public void addItem(String name, int amount) {
        items.put(name, amount);
    }

    void removeItem() {

    }

    public int getItemAmount(String name) {
        return items.get(name);
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
        return "";
    }
}