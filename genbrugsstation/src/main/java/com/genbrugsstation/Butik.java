package com.genbrugsstation;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Butik extends Space {

    private static HashMap<Integer, Upgrades> upgrades;
    private String[] commands = {"exit", "go", "help", "buy", "reset"};
    private boolean isHandled;
    private final HashMap<Integer, Upgrades> allUpgrades;

    public Butik(String name) {
        super(name);
        allUpgrades = new HashMap<Integer, Upgrades>();
        upgrades = new HashMap<Integer, Upgrades>();
        initUpgrades(allUpgrades);
        initUpgrades(upgrades);
        this.isHandled = super.getHandled();
    }

    @Override
    public void welcome() {
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

    public HashMap<Integer, Upgrades> getAllUpgrades() {
        return allUpgrades;
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

    private void initUpgrades(HashMap<Integer, Upgrades> hm){
        hm.put(1, new Upgrades("Cykelsti", 120, 60, 1.5, "1", 2));
        hm.put(2, new Upgrades("Motorvej", 100, 0, 1.5, "2", 1));
        hm.put(3, new Upgrades("Billboards", 120, 0, 1.5, "3", 5));
        hm.put(4, new Upgrades("Bustoppested", 180, 60, 1.5, "4", 10));
        hm.put(5, new Upgrades("Solceller", 140, 60, 1.5, "5", 3));
        hm.put(6, new Upgrades("Filter i parksøen", 160, 60, 1.5, "6", 9));
        hm.put(7, new Upgrades("Isolerende vinduer", 200, 60, 1.5, "7", 11));
        hm.put(8, new Upgrades("Legeplads", 220, 60, 1.5, "8", 12));
        hm.put(9, new Upgrades("Farve i parksøen", 140, 0, 1.5, "9", 6));
        hm.put(10, new Upgrades("Parkeringshus", 160, 0, 1.5, "10", 4));
        hm.put(11, new Upgrades("Varmeanlæg m. oliefyr", 180, 0, 1.5, "11", 7));
        hm.put(12, new Upgrades("Fodboldstadion", 200, 0, 1.5, "12", 8));

    }

    // Metode til at hente pris baseret på en key
    public static int getUpgradePrice(int key) {
        if (upgrades.containsKey(key)) {
            return upgrades.get(key).getPrice();
        } else {
            return -1;
        }
    }

    // Metode til at hente xp baseret på en key
    public static int getUpgradeXp(int key) {
        if (upgrades.containsKey(key)) {
            return upgrades.get(key).getXP();
        } else {
            return -1;
        }
    }

    // Metode til at hente navn baseret på en key
    public static String getUpgradeName(int key) {
        if (upgrades.containsKey(key)) {
            return upgrades.get(key).getName();
        } else {
            return null;
        }
    }

    public static String getHints(int key){
        if (upgrades.containsKey(key)) {
            return upgrades.get(key).getHint();
        } else {
            return null;
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
}
