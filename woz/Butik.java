import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

public class Butik extends Space implements DefaultSpace {

    private TreeMap<String, Upgrades> upgrades;
    private String[] commands = {"exit", "go", "help", "buy", "reset"};
    private boolean isHandled;

    void firstDayWelcome() {
        System.out.println("Velkommen til shoppen! Butikkens udvalg er vist foroven.\n" +
                "Her kan du få brugt mønter, som du får, når du genanvender skrald fra genbrugsstationen!\n" +
                "Du må træffe de rigtige beslutninger, når du skal investere i opgraderingerne, for de er vigtige for din bys bæredygtighed!");
    }
    public Butik(String name) {
        super(name);
        upgrades = new TreeMap<String, Upgrades>(String.CASE_INSENSITIVE_ORDER);
        initUpgrades();
        this.isHandled = super.getHandled();
    }

    public TreeMap<String, Upgrades> getUpgrades(){
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
