/* Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.Set;

//----------------------------------------------------------------------------
/*math importeret for genereret skrald.
hashmap og map importeret til butikken - pris hører til vare*/
import java.lang.Math;
import java.util.HashMap;
import java.util.Map;
//--------------------------------------------------------------------------


class Space extends Node{
  //-----------------------------------------------------------------------------------------
  boolean isHandled;
  private int generatedTrash;


  //getter og setter som vi bl.a. skal bruge i resetDay() i Context
  public int getGeneratedTrash(){
    return generatedTrash;
  }

  public void setGeneratedTrash(int newAmount){
    generatedTrash = newAmount;
  }
  //-----------------------------------------------------------------------------------------




  Space (String name) {
    super(name);
    isHandled = false;
    generatedTrash = (int)(Math.random()*(15 - 1) + 1);
  }
  
  //----------------------------------------------------------------------------------
  @Override
  public String toString(){
    return name;
  }
  //-----------------------------------------------------------------------------------

  public void welcome () {
    System.out.println("You are now at " + name);
    Set<String> exits = edges.keySet();
    System.out.println("Current locations are:"); //ændret "exits" til "locations" - dette skal ændres til dansk tho
    for (String exit : exits) {
      System.out.println(" - " + exit);
    }

    //----------------------------------------------------------------------------------------------------------------
    
    // handleRoom(name, )
    switch(name){
    case "Butik": 
      shopNow();
      World.butik.isHandled = true;
      // System.out.println("you handled the butik. ");//placeholder/tjekker bare at det går igennem

      break;

    case "Genbrugsstation": 
      recycle();
      World.genbrugsstation.isHandled = true;
      // System.out.println("you handled the genbrugsstation. ");//placeholder/tjekker bare at det går igennem

      break;

    case "Park": 
      collectTrashPark();
      World.park.isHandled = true;
      // System.out.println("you handled the park. ");//placeholder/tjekker bare at det går igennem
      break;

    case "Hospital": 
      collectTrashHospital();
      World.hospital.isHandled = true;
      // System.out.println("you handled the hospital. ");//placeholder/tjekker bare at det går igennem
      break;

    case "Bymidte":
      collectTrashBymidte();
      World.bymidte.isHandled = true;
      // System.out.println("you handled the bymidte. ");//placeholder/tjekker bare at det går igennem
      break;

    case "Kontor":
      Game.player.getStatus();

    default: 
      break;
    }
  }



  private void shopNow(){
    System.out.println("du er i butikken nu");
    int lvl = Game.player.getLevel();

    //laver et key-value map, så hhv pris og navn på udvidelse hænger sammen.
    Map<String, Integer> extensions = new HashMap<>();

    //afhængigt af level, har man adgang til forskellige varer.
    switch(lvl){
    case 1: 
      extensions.put("Billboards på Rådhuspladsen ", 20);
      extensions.put("Solceller ", 150);
      extensions.put("Cykelsti ", 10);
      break;
    case 2:
      extensions.put("Billboards på Rådhuspladsen ", 20);
      extensions.put("Solceller ", 150);
      break;
    case 3:
      extensions.put("Billboards på Rådhuspladsen ", 20);
      extensions.put("Solceller ", 150);
      extensions.put("Isolerende vinduer ", 30);
      break;
    case 4:
      extensions.put("Supermotorvej ", 20);
      extensions.put("Parkeringshus ", 150);
      extensions.put("Isolerende vinduer ", 70);
      break;
    case 5: 
      extensions.put("Varmeanlæg med oliefyr ", 50);
    default:
      break;
    }
    System.out.println("Du er trådt ind i butikken. Du har følgende udvalg: \n" + extensions.toString());

    //kommando til at købe
  
  }

  private void collectTrashPark(){
    System.out.println("collecting trash at this park; " + generatedTrash); //placeholder
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


  
  public void goodbye () {//tom metode
  }
  
  @Override
  public Space followEdge (String direction) {
    return (Space) (super.followEdge(direction));
  }
}
