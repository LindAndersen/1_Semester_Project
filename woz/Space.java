/* Space class for modeling spaces (rooms, caves, ...)
 */
/*math importeret for genereret skrald.
hashmap og map importeret til butikken - pris hører til vare*/
import java.lang.Math;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Set;
//-----

class Space extends Node {
  ArrayList<String> commands = new ArrayList<String>();
  boolean isHandled;
  private Map<String, int[]> extensions;
  private int generatedTrash;

  Space (String name) {
    super(name);
    isHandled = false;
    extensions = new HashMap<>(); //laver et key-value map, så hhv pris og navn på udvidelse hænger sammen.
    generatedTrash = (int)(Math.random()*(15 - 1) + 1); 

  }

  public void makeHandled() {
    isHandled = !isHandled; //toggles isHandled to true or false depending on its current value
  }

  //getter for generated trash
  public int getGeneratedTrash(){
    return generatedTrash;
  }

  public Map<String, int[]> getExtensions() {
    /*
    returns the map of key-value of the extensions you can buy.
    case_insensitive_order so that when we compare the parameter with the elements
    in the shop, we are not case sensitive. TreeMap can be case insensitive
    */
    Map<String, int[]> lowerExtensions = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    lowerExtensions.putAll(extensions);

    return lowerExtensions;
  }

  //sets amount of trash in a location
  public void setGeneratedTrash(int newAmount){
    generatedTrash = newAmount;
  }

  public void welcome() {
    System.out.printf("%n%s%n", name);
    System.out.println("\nDu er nu ved "+name);

    updateExits();

    //acts according to the location
    switch(name){
    case "Butik": 
      showShop();
      makeHandled();

      break;

    case "Genbrugsstation": 
      recycle();
      makeHandled();

      break;

    case "Park": 
      collectTrashPark();
      makeHandled();
      break;

    case "Hospital": 
      collectTrashHospital();
      makeHandled();
      break;

    case "Bymidte":
      collectTrashBymidte();
      makeHandled();
      break;

    case "Kontor":
      //player.getStatus();
      break;

    default: 
      break;
    }
  }
  
  void updateShop(){
    /*
    checks the player's level and adjusts the selection in the shop
    */
    int lvl = Game.player.getLevel();

    switch(lvl){
    case 1: 
      extensions.put("Billboards på Rådhuspladsen", new int[]{20, 10});
      extensions.put("Solceller", new int[]{150, 10});
      extensions.put("Cykelsti", new int[]{10, 10});
      break;
    case 2:
      extensions.put("Billboards på Rådhuspladsen", new int[]{20,10});
      extensions.put("Solceller", new int[]{150, 10});
      break;
    case 3:
      extensions.put("Billboards på Rådhuspladsen", new int[]{20, 10});
      extensions.put("Solceller", new int[]{150, 10});
      extensions.put("Isolerende vinduer", new int[]{30, 10});
      break;
    case 4:
      extensions.put("Supermotorvej", new int[]{20, 10});
      extensions.put("Parkeringshus", new int[]{150, 10});
      extensions.put("Isolerende vinduer", new int[]{70, 10});
      break;
    case 5: 
      extensions.put("Varmeanlæg med oliefyr", new int[]{50, 10});
    default:
      break;
    }
  }

  public void showShop() {
    //prints out the shop - updates it first
    updateShop();
    System.out.println("Du er trådt ind i butikken. Du har følgende udvalg: \n");
    for (String key : extensions.keySet()){
      int[] priceXP = extensions.get(key);
      System.out.printf(" - Navn: %s, pris: %d, XP: %d%n", key, priceXP[0], priceXP[1]);
    }
  }
  
   private void collectTrashPark(){
    System.out.println("collecting trash at this park; " + generatedTrash); //placeholder
   }

  public void updateExits() {
    //updates what exits are available and lists the relevant commands for the location
    System.out.println("\n-------------------------------------------");
    Set<String> exits = edges.keySet();
    System.out.println("Du kan gå mod:");
    for (String exit: exits) {
      System.out.println(" - "+exit);
    }

    System.out.println("Rumhandlinger");
    for (String command : commands) {
      System.out.printf(" - %s%n", command);
    }
  }


  private void collectTrashBymidte(){
    System.out.println("collecting trash at bymidte; " + generatedTrash); //placeholder
  }

  private void collectTrashHospital(){
    System.out.println("collecting trash at this hospital; " + generatedTrash); //placeholder
  }


  private void recycle(){
    System.out.println("du har afleveret dit affald for i dag"); //placeholder

    
  }


  

  public void goodbye () {
    System.out.printf("%nHere will be some information about %s (the room you just left)", name);
  }

  public void addCommand(String cmdName) {
    commands.add(cmdName);
  }

  public boolean isCommandPossible(String cmdName) {
    //checks wether the command is recognizable from the list of commands
    for (String command : commands) {
      if (command.equals(cmdName)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Space followEdge (String direction) {
    return (Space)(super.followEdge(direction));
  }

  public String spaceToString(){
    return name;
  }
}
