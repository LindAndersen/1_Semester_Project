/* Context class to hold all context relevant to a session.
 */

import java.util.Map;
import java.util.HashMap;

class Context {

  private Space current;
  private Player player;
  private boolean done = false;
  private int day;

  Context (Space node, Player player) {
    current = node;
    this.player = player;
    day = 1;
  }

  //resets amount of generated trash, the handleRoom(), increments the day and transitions to "Kontor"

  void resetDay(){
    World.park.setGeneratedTrash((int)(Math.random()*(15 - 1) + 1));
    World.bymidte.setGeneratedTrash((int)(Math.random()*(15 - 1) + 1));
    World.hospital.setGeneratedTrash((int)(Math.random()*(15 - 1) + 1));
    
    World.park.makeHandled();
    World.bymidte.makeHandled();
    World.hospital.makeHandled();
    World.genbrugsstation.makeHandled();
    World.butik.makeHandled();
    
    day++;

    transition("kontor");//man "vågner op" i kontoret igen

    
  }

  public int getDay(){//gets the day-number
    return day;
  }

    //checks if all available actions for the day are done
  public boolean isDayDone(Space... args){
    for (Space s : args) {
      if (!s.isHandled) {
        return false;
      }
    }
    return true;
  }
  
  public Space getCurrent() {
    return current;
  }

  public Player getPlayer() {
    return player;
  }

  public void buyExecuter(String[] parameters) {
    String item = parameters[0]; //gets the parameter from command (what to buy)
    Map<String, int[]> lowerExtensions = current.getExtensions();
    ResponseObject response = containsKey(lowerExtensions.keySet().toArray(new String[0]), item);

    if (response.b) {
      int[] priceXP = lowerExtensions.get(response.s);

      if (player.canAfford(priceXP[0])) {
        //Add to inventory
        player.addToInventory(item, 1);
        player.subtractMoney(priceXP[0]);
        player.addPoints(priceXP[1]);

        System.out.printf("%nDu har købt %s. Godt gået!", response.s);

      } else {
        System.out.println("Du har ikke råd til denne udvidelse");
      }
    } else {
      System.out.println("Denne udvidelse eksisterer ikke i shoppen");
    }
    System.out.println("inventory: " + player.getInventory());
  }
  
  public void transition (String direction) {
    Space next = current.followEdge(direction);
    if (next == null) {
      System.out.println("You are confused, and walk in a circle looking for '"+direction+"'. In the end you give up 😩");
    } else {
      current.goodbye();
      current = next;
      current.welcome();
    }
  }

  public void youStupid () {
    System.out.println("You are an idiot, and have used this command wrong");
  }
  
  public void makeDone () {
    done = true;
  }
  
  public boolean isDone () {
    return done;
  }

//Helpers


  //checks if the itemName is in the array
  private ResponseObject containsKey(String[] hm, String itemName) {
    for (String name : hm) {
      if (itemName.equals(name.toLowerCase().trim()) || name.toLowerCase().trim().contains(itemName)) {
        return new ResponseObject(true, name);
      }
    }
    return new ResponseObject(false, null);
  }
}


class ResponseObject {
  boolean b;
  String s;

  ResponseObject(boolean b, String s) {
    this.b = b;
    this.s = s;
  }
}   