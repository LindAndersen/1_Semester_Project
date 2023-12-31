package com.genbrugsstation;

import java.io.Serializable;

class Upgrades implements Serializable {
    private String name;
    private int xp;
    private int price;
    private double modifier;
    private String hint;
    private int relatedUpgradeIndex;


    Upgrades(String name, int price, int xp, double modifier, String hint, int relatedUpgradeIndex){
        this.name = name;
        this.price = price;
        this.xp = xp;
        this.modifier = modifier;
        this.hint = hint;
        this.relatedUpgradeIndex = relatedUpgradeIndex;
    }

    public String getHint() {
        return hint;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getXP(){
        return xp;
    }

    public int getRelatedUpgradeIndex() {
        return relatedUpgradeIndex;
    }

    @Override
    public String toString(){
        return name + ", xp: " + xp + ", pris: " + price;
    }

}
