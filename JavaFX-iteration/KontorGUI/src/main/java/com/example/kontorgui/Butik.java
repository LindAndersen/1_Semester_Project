package com.example.kontorgui;


import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Butik extends Space implements DefaultSpace {

    private HashMap<Integer, Upgrades> upgrades;
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

    public void initUpgrades(){

        upgrades.put(1, new Upgrades("Cykelsti", 50, 200, 1.5, "1", 2));
        upgrades.put(2, new Upgrades("Motorvej", 50, 200, 1.5, "2", 1));
        upgrades.put(3, new Upgrades("Billboard", 50, 200, 1.5, "3", 5));
        upgrades.put(4, new Upgrades("Skraldespande", 50, 200, 1.5, "4", 10));
        upgrades.put(5, new Upgrades("Solceller", 50, 200, 1.5, "5", 3));
        upgrades.put(6, new Upgrades("Filter i parksøen", 50, 200, 1.5, "6", 9));
        upgrades.put(7, new Upgrades("Isolerende vinduer", 50, 200, 1.5, "7", 11));
        upgrades.put(8, new Upgrades("Legeplads", 50, 200, 1.5, "8", 12));
        upgrades.put(9, new Upgrades("Farve i parksøen", 50, 200, 1.5, "9", 6));
        upgrades.put(10, new Upgrades("Parkeringshus", 50, 200, 1.5, "10", 4));
        upgrades.put(11, new Upgrades("Varmeanlæg m. oliefyr", 50, 200, 1.5, "11", 7));
        upgrades.put(12, new Upgrades("Fodboldstadion", 50, 200, 1.5, "12", 8));

    }

    public void showUpgrades() {
        //formatting output like in CommandHelp

        Set<Integer> names = upgrades.keySet();

      
        // present list of upgrades
        for(Integer e : upgrades.keySet()){
            System.out.printf(" - [%d] %s  pris: %d, XP: %d%n", e, upgrades.get(e).getName(), upgrades.get(e).getPrice(), upgrades.get(e).getXP());            
        }
    }



    void removeUpgrade(int key) {
        upgrades.remove(key);
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
