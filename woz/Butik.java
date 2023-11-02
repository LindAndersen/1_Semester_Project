import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Butik extends Space implements DefaultSpace {

    private HashMap<Integer, Upgrades> upgrades;
    private String[] commands = {"exit", "go", "help", "buy", "reset"};
    private boolean isHandled;

    void firstDayWelcome() {
        System.out.println("");
        System.out.println("Velkommen til shoppen! Butikkens udvalg er vist foroven");
        System.out.println("Her kan du få brugt mønter, som du får, når du genanvender skrald fra genbrugsstationen!");
        System.out.println("Du må træffe de rigtige beslutninger, når du skal investere i opgraderingerne, for de er vigtige for din bys bæredygtighed!");
    }
    public Butik(String name) {
        super(name);
        upgrades = new HashMap<Integer, Upgrades>();
        initUpgrades();
        this.isHandled = super.getHandled();
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
    public void welcome() {
        showUpgrades();
        makeHandled();
    }

    @Override
    public void goodbye(){
    }

    public void initUpgrades(){
        upgrades.put(1, new Upgrades("Cykelsti", 50, 200, 1.5, "1"));
        upgrades.put(2, new Upgrades("Motorvej", 50, 200, 1.5, "2"));
        upgrades.put(3, new Upgrades("Billboard", 50, 200, 1.5, "3"));
        upgrades.put(4, new Upgrades("Skraldespande", 50, 200, 1.5, "4"));
        upgrades.put(5, new Upgrades("Solceller", 50, 200, 1.5, "5"));
        upgrades.put(6, new Upgrades("Filter i parksøen", 50, 200, 1.5, "6"));
        upgrades.put(7, new Upgrades("Isolerende vinduer", 50, 200, 1.5, "7"));
        upgrades.put(8, new Upgrades("Legeplads", 50, 200, 1.5, "8"));
        upgrades.put(9, new Upgrades("Farve i parksøen", 50, 200, 1.5, "9"));
        upgrades.put(10, new Upgrades("Parkeringshus", 50, 200, 1.5, "10"));
        upgrades.put(11, new Upgrades("Varmeanlæg m. oliefyr", 50, 200, 1.5, "11"));
        upgrades.put(12, new Upgrades("Fodboldstadion", 50, 200, 1.5, "12"));
    }

    public void showUpgrades() {
        //formatting output like in CommandHelp

        Set<Integer> names = upgrades.keySet();

      
        // present list of upgrades
        for(int e : upgrades.keySet()){
            System.out.printf(" - %s  pris: %d, XP: %d%n", upgrades.get(e).getName(), upgrades.get(e).getPrice(), upgrades.get(e).getXP());            
        }
    }


    void removeUpgrade(int name) {
        upgrades.remove(name);
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
