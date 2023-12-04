package com.genbrugsstation;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Butik extends Space implements DefaultSpace {

    private static HashMap<Integer, Upgrades> upgrades;
    private String[] commands = {"exit", "go", "help", "buy", "reset"};
    private boolean isHandled;

    public Butik(String name) {
        super(name);
        upgrades = new HashMap<Integer, Upgrades>();
        initUpgrades();
        this.isHandled = super.getHandled();
    }

    @Override
    public void welcome() {
        System.out.println("\n_______________________________________________________");
        System.out.println("\nButikkens udvalg af opgraderinger:");
        System.out.println("smt");
        showUpgrades();
        makeHandled();
    }

    public void firstDayWelcome() {
        System.out.println("\n_______________________________________________________");
        System.out.println("\n" + "Velkommen til shoppen! Butikkens udvalg er vist foroven.\n" +
                "Her kan du få brugt mønter, som du får, når du genanvender skrald fra genbrugsstationen!\n" +
                "Du må træffe de rigtige beslutninger, når du skal investere i opgraderingerne, for de er vigtige for din bys bæredygtighed!\n" +
                "Du kan altid tjekke byens status og din udvikling som borgmester i kontoret." +
                "Du kan bruge 'buy' for at købe, og 'help' for at se andre tilgængelige commands i rummet!");
    }

    public HashMap<Integer, Upgrades> getUpgrades(){
        return upgrades;
    }

      @Override
    public void makeHandled(){
        isHandled = true;
    }

    @Override
    public void undoHandled(){
        isHandled = false;
    }


    @Override
    public boolean getHandled(){
        return isHandled;
    }


    @Override
    public void goodbye(){
    }

    private void initUpgrades(){

        upgrades.put(1, new Upgrades("Cykelsti", 120, 60, 1.5, "1", 2));
        upgrades.put(2, new Upgrades("Motorvej", 100, 0, 1.5, "2", 1));
        upgrades.put(3, new Upgrades("Billboard", 120, 0, 1.5, "3", 5));
        upgrades.put(4, new Upgrades("Bustoppested", 180, 60, 1.5, "4", 10));
        upgrades.put(5, new Upgrades("Solceller", 140, 60, 1.5, "5", 3));
        upgrades.put(6, new Upgrades("Filter i parksøen", 160, 60, 1.5, "6", 9));
        upgrades.put(7, new Upgrades("Isolerende vinduer", 200, 60, 1.5, "7", 11));
        upgrades.put(8, new Upgrades("Legeplads", 220, 60, 1.5, "8", 12));
        upgrades.put(9, new Upgrades("Farve i parksøen", 140, 0, 1.5, "9", 6));
        upgrades.put(10, new Upgrades("Parkeringshus", 160, 0, 1.5, "10", 4));
        upgrades.put(11, new Upgrades("Varmeanlæg m. oliefyr", 180, 0, 1.5, "11", 7));
        upgrades.put(12, new Upgrades("Fodboldstadion", 200, 0, 1.5, "12", 8));

    }



    public void showUpgrades() {
        //formatting output like in CommandHelp

        Set<Integer> names = upgrades.keySet();
        // present list of upgrades

        for(Integer e : upgrades.keySet()){
            System.out.printf(" - [%d] %s  pris: %d, XP: %d%n", e, upgrades.get(e).getName(), upgrades.get(e).getPrice(), upgrades.get(e).getXP());
        }
    }

    // Add a method to get the price of an upgrade based on its key
    public static int getUpgradePrice(int key) {
        if (upgrades.containsKey(key)) {
            return upgrades.get(key).getPrice();
        } else {
            return -1; // or throw an exception, depending on your error handling strategy
        }
    }

    // Add a method to get the xp of an upgrade based on its key
    public static int getUpgradeXp(int key) {
        if (upgrades.containsKey(key)) {
            return upgrades.get(key).getXP();
        } else {
            return -1; // or throw an exception, depending on your error handling strategy
        }
    }

    // Add a method to get the name of an upgrade based on its key
    public static String getUpgradeName(int key) {
        if (upgrades.containsKey(key)) {
            return upgrades.get(key).getName();
        } else {
            return null; // or throw an exception, depending on your error handling strategy
        }
    }



    void removeUpgrade(int key) {
        upgrades.remove(key);
    }


    public void removeFromShop(Butik butik, Upgrades selectedUpgrade, int upgradeIndex){
        //Determine the second upgrade to remove based on the selected upgrade.
        Player player = Game.getContext().getPlayer();
        int secondUpgradeToRemove = selectedUpgrade.getRelatedUpgradeIndex();
//      printHint(butik, upgradeIndex);

        System.out.println("Du har købt upgraderingen " + selectedUpgrade.getName());

        butik.removeUpgrade(upgradeIndex);//fjern upgrade fra shop

        if (upgrades.containsKey(secondUpgradeToRemove)) {
            Upgrades relatedUpgrade = upgrades.get(secondUpgradeToRemove);
            butik.removeUpgrade(secondUpgradeToRemove); // Remove the related second upgrade.
            System.out.println("Du har også fjernet " + relatedUpgrade.getName() + " fra butikken.");

        } else {
            System.out.println("Error: Related upgrade not found.");
        }

        System.out.println("\nDu har så mange mønter nu: " + player.getMoney());
        System.out.println("Du har så meget xp nu: " + player.getXP() + "\n");

    }


    @Override
    public void showTrash() {
    }

    @Override
    public boolean isCommandReachable(String name) {
        return super.isCommandReachable(name, commands);
    }

    @Override
    public String[] getCommands() {
        return commands;
    }
}
