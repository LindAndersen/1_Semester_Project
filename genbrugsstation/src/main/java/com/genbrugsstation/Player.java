package com.genbrugsstation;

import java.io.Serializable;
import java.util.HashMap;

class Player implements Serializable {
    private String name;
    private static int xp;
    private static int lvl;
    private static int money;
    private static Inventory inventory;
    private static int buyCount;

    Player(String name) {
        this.name = name;
        xp = 0;
        lvl = 0;
        money = 1020;
        inventory = new Inventory();
        resetInventory();
        buyCount = 0;
    }

    //buyCount holder styr på antal købte opgraderinger
    public int getBuyCount(){
        return buyCount;
    }
    

    public Inventory getInventory() {
        return inventory;
    }

    //adds XP
    private void addXP(int amount) {
        xp += amount;
        lvl = getLvl();
    }

    //adds money
    private void addMoney(int amount) {
        if (amount > 0) {
            money += amount;
        }
    }

    //subtracts money. call canAfford() to check
    private void subtractMoney(int amount) {
        if (canAfford(amount)) {
            money -= amount;
        }
    }

    //returns true if player can afford buying an item with given price
    private boolean canAfford(int price) {
        if (money >= price) {
            return true;
        } else {
            //System.out.println("Du har desværre ikke råd :(");
            return false;
        }
    }

    private void addToInventory(String name, int amount) {
        //calls an add-method in Inventory class
        //System.out.printf("Du har tilføjet %d %s til din inventar%n", amount, name);
        inventory.addItem(name, amount);
    }
    public int getXP() {
        return xp;
    }

    public int getLvl() {
        //Tjekker hvor meget xps værdi er og sætter lvl value efter det
        int lvl = 0;

        if (99 < xp && xp < 200) {
            lvl = 1;
        } else if (199 < xp && xp < 300) {
            lvl = 2;
        } else if (299 < xp && xp < 400) {
            lvl = 3;
        } else if (399 < xp && xp < 500) {
            lvl = 4;
        } else if (499 < xp){
            lvl = 5; // Alt over 400 xp er level 5
        }

        return lvl;
    }

    public int getRemainingXP() {
        int remaining = 0;
        switch (getLvl()) {
            case 1:
                remaining = 200 - xp;
                break;
            case 2:
                remaining = 300 - xp;
                break;
            case 3:
                remaining = 400 - xp;
                break;
            case 4:
                remaining = 500 - xp;
                break;
            case 5:
                remaining = 100;
                break;
        }
        return remaining;
    }

    public int getMoney() {
        return money;
    }

    private void emptyInventory() {
        inventory = new Inventory();
        resetInventory();
    }

    //nulstiller inventaret, da der ellers kommer fejl i inventar- og status-menu-view.
    //de kan ikke vise en mængde på noget, der ikke eksisterer
    private void resetInventory(){
        inventory.addItem("flasker", 0);
        inventory.addItem("plastik", 0);
        inventory.addItem("aviser", 0);
        inventory.addItem("batterier", 0);
        inventory.addItem("metalskrot", 0);
    }

    public int getTrashAmount() {
        return inventory.getTotalAmount();

    }

    int[] recycleGreen() {
        int amountOfTrash = getTrashAmount();
        int money = 3 * amountOfTrash;
        int xp = (int) (0.5 * amountOfTrash);
        emptyInventory();
        addMoney(money);
        addXP(xp);
        int[] moneyXP = {money, xp};
        return moneyXP;
    }

    int[] recycleBad() {
        int amountOfTrash = getTrashAmount();
        emptyInventory();
        int money = 7 * amountOfTrash;
        int xp = 2 * amountOfTrash;
        addMoney(money);
        addXP(-xp);
        int[] moneyXP = {money, -xp};
        return moneyXP;
    }

    boolean pickup(String name, int amount, Trash[] trash) throws TrashNotFoundException {
        Context context = Game.getContext();
        boolean canPickup = context.getCurrent().subtractTrash(name, amount, trash);

        if (canPickup) {
            context.getPlayer().addToInventory(name, amount);
            context.getPlayer().addXP((int)(0.5 * amount));
        }

        return canPickup;
    }


    void buy(String s, Context context) {
        Butik butik = (Butik) context.getCurrent();
        HashMap<Integer, Upgrades> upgrades = butik.getUpgrades();

        try {
            int upgradeIndex = Integer.parseInt(s);

            if (upgrades.containsKey(upgradeIndex)) {//tjekker om den angivne upgrade eksisterer

                Upgrades selectedUpgrade = upgrades.get(upgradeIndex);
                int price = selectedUpgrade.getPrice();
                int xp = selectedUpgrade.getXP();

                if (canAfford(price)) {//hvis spiller har råd til upgraden...
                    subtractMoney(price);//træk penge
                    addXP(xp);//tilføj xp
                    butik.removeFromShop(butik, selectedUpgrade, upgradeIndex);
                    buyCount++;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

