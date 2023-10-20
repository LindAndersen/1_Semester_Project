/* Context class to hold all context relevant to a session.
 */

import java.util.*;

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

  //---------------------------------------------------------------------------------------------
  //resetter generated trash, markeringen på om rummet er håndteret og sætter lokation til kontor

  void resetDay(){
    World.park.setGeneratedTrash((int)(Math.random()*(15 - 1) + 1));
    World.bymidte.setGeneratedTrash((int)(Math.random()*(15 - 1) + 1));
    World.hospital.setGeneratedTrash((int)(Math.random()*(15 - 1) + 1));
    
    World.park.isHandled = false;
    World.bymidte.isHandled = false;
    World.hospital.isHandled = false;
    World.genbrugsstation.isHandled = false;
    World.butik.isHandled = false;
    
    day++;

    transition("kontor");//man "vågner op" i kontoret igen

    
  }

  public int getDay(){
    return day;
  }



  public boolean isDayDone(Space s1, Space s2, Space s3, Space s4, Space s5){
    if((s1.isHandled && s2.isHandled && s3.isHandled && s4.isHandled && s5.isHandled)){
      return true;
    }else{
      return false;
    }
  }
  
  public Space getCurrent() {
    return current;
  }

  public Player getPlayer() {
    return player;
  }

  public void buyExecuter(String[] parameters) {
    String item = parameters[0];
    Map<String, int[]> lowerExtensions = current.getExtensions();

    if (containsKey(lowerExtensions.keySet().toArray(new String[0]), item)) {
      int[] priceXP = lowerExtensions.get(item);
      if (player.canAfford(priceXP[0])) {
        //Add to inventory
        player.subtractMoney(priceXP[0]);
        player.addPoints(priceXP[1]);

        System.out.printf("%nDu har købt %s. Godt gået!", item);

      } else {
        System.out.println("Du har ikke råd til denne udvidelse");
      }
    } else {
      System.out.println("Denne udvidelse eksisterer ikke i shoppen");
    }
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


  private boolean containsKey(String[] hm, String itemName) {
    for (String name : hm) {
      if (itemName.equals(name.toLowerCase().trim())) {
        return true;
      }
    }
    return false;
  }



}
