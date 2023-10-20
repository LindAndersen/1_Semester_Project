/* Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.Set;

class Space extends Node {
  Space (String name) {
    super(name);
  }
  
  public void welcome () {
    System.out.println("You are now at " + name);
    Set<String> exits = edges.keySet();
    System.out.println("Current locations are:"); //ændret "exits" til "locations" - dette skal ændres til dansk tho
    for (String exit : exits) {
      System.out.println(" - " + exit);
    }
    //----------------------------------------------------------------------------------------------------------------
    //gør det muligt at interagere med lokationerne - kalder funktioner i Locations-class
    switch(name){
    case "Butik": 
      Locations.shopNow();
      break;

    case "Genbrugsstation": 
      Locations.recycle(4);
      break;

    case "Park": 
      Locations.collectTrashPark();
      break;

    case "Hospital": 
      Locations.collectTrashHospital();
      break;

    case "Bymidte":
      Locations.collectTrashBymidte();
      break;

    default: System.out.println("cant do anything here buddy");


    }
   

    //----------------------------------------------------------------------------------------------------------------
  }
  
  public void goodbye () {//tom metode
  }
  
  @Override
  public Space followEdge (String direction) {
    return (Space) (super.followEdge(direction));
  }
}
