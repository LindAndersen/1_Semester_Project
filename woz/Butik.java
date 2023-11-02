import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

public class Butik extends Space implements DefaultSpace {

<<<<<<< Updated upstream
    private HashMap<Integer, Upgrades> upgrades;
    private String[] commands = {"exit", "go", "help", "buy", "reset"};
    private boolean isHandled;
=======
    private TreeMap<Integer, Upgrades> upgrades;
    private String[] commands = {"exit", "go", "help", "buy", "reset"};
    private boolean isHandled;
 
>>>>>>> Stashed changes

    void firstDayWelcome() {
        System.out.println("");
        System.out.println("Velkommen til shoppen! Butikkens udvalg er vist foroven");
        System.out.println("Her kan du få brugt mønter, som du får, når du genanvender skrald fra genbrugsstationen!");
        System.out.println("Du må træffe de rigtige beslutninger, når du skal investere i opgraderingerne, for de er vigtige for din bys bæredygtighed!");
    }
    public Butik(String name) {
        super(name);
<<<<<<< Updated upstream
        upgrades = new HashMap<Integer, Upgrades>();
=======
        upgrades = new TreeMap<Integer, Upgrades>();
>>>>>>> Stashed changes
        initUpgrades();
        this.isHandled = super.getHandled();
    }

<<<<<<< Updated upstream
    public HashMap<Integer, Upgrades> getUpgrades(){
=======
    public TreeMap<Integer, Upgrades> getUpgrades(){
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
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
=======
        upgrades.put(1, new Upgrades("Cykelsti", 1, 5, 1.5));
        upgrades.put(2, new Upgrades("Motorvej", 50, 200, 1.5));
        upgrades.put(3, new Upgrades("Billboard", 50, 200, 1.5));
        upgrades.put(4, new Upgrades("Skraldespande", 50, 200, 1.5));
        upgrades.put(5, new Upgrades("Solceller", 50, 200, 1.5));
        upgrades.put(6, new Upgrades("Filter i parksøen", 50, 200, 1.5));
        upgrades.put(7, new Upgrades("Isolerende vinduer", 50, 200, 1.5));
        upgrades.put(8, new Upgrades("Legeplads", 50, 200, 1.5));
        upgrades.put(9, new Upgrades("Farve i parksøen", 50, 200, 1.5));
        upgrades.put(10, new Upgrades("Parkeringshus", 50, 200, 1.5));
        upgrades.put(11, new Upgrades("Varmeanlæg m. oliefyr", 50, 200, 1.5));
        upgrades.put(12, new Upgrades("Fodboldstadion", 50, 200, 1.5));
>>>>>>> Stashed changes
    }

    public void showUpgrades() {
        //formatting output like in CommandHelp

<<<<<<< Updated upstream
        Set<Integer> names = upgrades.keySet();

      
        // present list of upgrades
        for(int e : upgrades.keySet()){
            System.out.printf(" - %s  pris: %d, XP: %d%n", upgrades.get(e).getName(), upgrades.get(e).getPrice(), upgrades.get(e).getXP());            
=======
        Set<Integer> keys = upgrades.keySet();

        ArrayList<String> names = new ArrayList<>(); 
        for(Integer i : keys){
            names.add(upgrades.get(i).getName());
        }

        // find max length of command name
        int max = 0;
        for (String name : names) {
            int length = names.size();
            if (length > max){
                max = length;
            }
        }
      
        // present list of upgrades
        for(Integer e : upgrades.keySet()){
            System.out.printf(" - %d %-"+10+"s  pris: %d, XP: %d%n", e, upgrades.get(e).getName(), upgrades.get(e).getPrice(), upgrades.get(e).getXP());            
>>>>>>> Stashed changes
        }
    }


<<<<<<< Updated upstream
    void removeUpgrade(int name) {
        upgrades.remove(name);
=======
    void removeUpgrade(int key) {
        upgrades.remove(key);
>>>>>>> Stashed changes
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
