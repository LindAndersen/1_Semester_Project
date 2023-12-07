package com.genbrugsstation;

/* Context class to hold all context relevant to a session.
 */
import java.io.Serializable;

public class Context implements Serializable {
  private boolean firstTime = true;
  private static Space current;
  private Player player;
  private int dayCounter;

  Context (Space node) {
    player  = new Player("Borgmester");
    dayCounter = 1;
    current = node;
  }
  
  public Space getCurrent() {
    return current;
  }

  public void setCurrent(Space newCurrent){
    current = newCurrent;
  }
  

  //En message for det første rum, du kommer ind i, ved spillet :D
    void firstRoomMessage() {
      System.out.println("\nPuha, der kan muligvis være meget skrald rundt omkring...");
      System.out.println("Når du bruger 'pickup' i et rum, kan du få et overblik, hvis der befinder sig skrald i rummet!");
      System.out.println("Lad os tjekke det! Prøv at bruge 'pickup' i rummet.");
      System.out.println("Herefter kan du bruge 'pickup [mængde] [type]' til at samle det specifikke skrald op");
    }
    void resetDay(World world){
        //nulstiller state i hvert rum og inkrementerer dayCounter
        Space[] locations = world.getLocations();//henter lokationerne

        for(Space loc : locations){
          if(loc instanceof Park || loc instanceof Villakvarter || loc instanceof Centrum || loc instanceof Genbrugsstation){
            //kun hvis rummet er en type, der har affald, skal affald resettes
            loc.setTrashSpace(loc.getTrash());
          }

          if(loc.getName().equals("Kontor")){
            setCurrent(loc);
            current.welcome();
          }
        }
        dayCounter++;
        System.out.println("\nDu er nu på " + dayCounter + ". dag");
    }

  public int getDay() {
    return dayCounter;
  }

  public Player getPlayer() {
    return player;
  }

}

