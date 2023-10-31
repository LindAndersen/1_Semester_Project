import java.util.Map;
// import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Butik extends Space implements DefaultSpace {

    // private ArrayList<Upgrades> upgrades;

    private HashMap<String, Upgrades> upgrades;
    private String[] commands = {"exit", "quit", "bye", "go", "help", "buy"};

    void firstDayWelcome() {
        System.out.println("Velkommen til shoppen!");
        System.out.println("Her kan du få brugt mønter, som du får, når du genanvender skrald fra genbrugsstationen!");
        System.out.println("Du må træffe de rigtige beslutninger, når du skal investere i opgraderingerne, for de er vigtige for din bys bæredygtighed!");
        System.out.println("");
        System.out.println("Butikkens udvalg er nu: ");
        showUpgrades();
    }
    public Butik(String name) {
        super(name);
        // upgrades = new ArrayList<Upgrades>();
        upgrades = new HashMap<String, Upgrades>();

        initUpgrades();
    }

    // public ArrayList<Upgrades> getUpgrades(){
    //     return upgrades;
    // }

    public HashMap<String, Upgrades> getUpgrades(){
        return upgrades;
    }


    @Override
    public void welcome() {
        showUpgrades();
    }

    @Override
    public void goodbye(){

    }

    public void initUpgrades(){
        upgrades.put("Cykelsti", new Upgrades("Cykelsti", 50, 200, 1.5));
        upgrades.put("Motorvej", new Upgrades("Motorvej", 50, 200, 1.5));
        upgrades.put("Billboard", new Upgrades("Billboard", 50, 200, 1.5));
        upgrades.put("Skraldespande", new Upgrades("Skraldespande", 50, 200, 1.5));
        upgrades.put("Solceller", new Upgrades("Solceller", 50, 200, 1.5));
        upgrades.put("Filter i parksøen", new Upgrades("Filter i parksøen", 50, 200, 1.5));
        upgrades.put("Isolerende vinduer", new Upgrades("Isolerende vinduer", 50, 200, 1.5));
        upgrades.put("Legeplads", new Upgrades("Legeplads", 50, 200, 1.5));
        upgrades.put("Farve i parksøen", new Upgrades("Farve i parksøen", 50, 200, 1.5));
        upgrades.put("Parkeringshus", new Upgrades("Parkeringshus", 50, 200, 1.5));
        upgrades.put("Varmeanlæg m. oliefyr", new Upgrades("Varmeanlæg m. oliefyr", 50, 200, 1.5));
        upgrades.put("Fodboldstadion", new Upgrades("Fodboldstadion", 50, 200, 1.5));
    }



    // public void initUpgrades(){
    //     upgrades.add(new Upgrades("Motorvej", 50, 200, 1.5));
    //     upgrades.add(new Upgrades("Cykelsti", 50, 200, 1.5));
    //     upgrades.add(new Upgrades("Billboard", 50, 200, 1.5));
    //     upgrades.add(new Upgrades("Skraldespande", 50, 200, 1.5));
    //     upgrades.add(new Upgrades("Solceller", 50, 200, 1.5));
    //     upgrades.add(new Upgrades("Filter i parksøen", 50, 200, 1.5));
    //     upgrades.add(new Upgrades("Offentlig transport", 50, 200, 1.5));
    //     upgrades.add(new Upgrades("Isolerende vinduer", 50, 200, 1.5));
    //     upgrades.add(new Upgrades("Legeplads", 50, 200, 1.5));
    //     upgrades.add(new Upgrades("Farve i parksøen", 50, 200, 1.5));
    //     upgrades.add(new Upgrades("Parkeringshus", 50, 200, 1.5));
    //     upgrades.add(new Upgrades("Varmeanlæg m. oliefyr", 50, 200, 1.5));
    //     upgrades.add(new Upgrades("Fodboldstadion", 50, 200, 1.5));
    // }

   

    public void showUpgrades() {
        //formatting output like in CommandHelp

        Set<String> names = upgrades.keySet();

        // find max length of command name
        int max = 0;
        for (String name : names) {
            int length = name.length();
            if (length > max){
                max = length;
            }
        }
      
        // present list of upgrades
        for(String e : upgrades.keySet()){
            System.out.printf(" - %-"+max+"s  pris: %d, XP: %d%n", upgrades.get(e).getName(), upgrades.get(e).getPrice(), upgrades.get(e).getXP());            
        }
    }


    void removeUpgrade(String name) {

    }

    @Override
    public void showTrash() {
    }

    @Override
    public boolean subtractTrash(String name, int amount) {
        return false;
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
