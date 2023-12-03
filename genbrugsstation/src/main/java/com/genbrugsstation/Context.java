package com.genbrugsstation;

/* Context class to hold all context relevant to a session.
 */
import java.io.Serializable;

class Context implements Serializable {
  private boolean firstTime = true;
  private static Space current;
  private boolean done = false;
  private static Player player;
  private int dayCounter = 1;
  //private static final long serialVersionUID = 6529685098267757696L;
  
  Context (Space node) {
    player  = new Player("Borgmester");
    current = node;
  }
  
  public Space getCurrent() {
    return current;
  }

  public void setCurrent(Space newCurrent){
    current = newCurrent;
  }
  

  //En message for det første rum, du kommer ind i, ved spillet :D
  public void firstRoomMessage() {
      System.out.println("\nPuha, der kan muligvis være meget skrald rundt omkring...");
      System.out.println("Når du bruger 'pickup' i et rum, kan du få et overblik, hvis der befinder sig skrald i rummet!");
      System.out.println("Lad os tjekke det! Prøv at bruge 'pickup' i rummet.");
      System.out.println("Herefter kan du bruge 'pickup [mængde] [type]' til at samle det specifikke skrald op");
    }

   public void resetDay(World world){
    //nulstiller state i hvert rum og inkrementerer dayCounter
    Space[] locations = world.getLocations();//henter lokationerne

    for(Space loc : locations){
      if(loc instanceof Park || loc instanceof Villakvarter || loc instanceof Centrum || loc instanceof Genbrugsstation){
        //kun hvis rummet er en type, der har affald, skal affald resettes
        loc.setTrashSpace(loc.getTrash());
      }

      loc.undoHandled();//sætter isHandled i hvert rum til 

      if(loc.getName().equals("Kontor")){
        setCurrent(loc);
      }
    }
    dayCounter++;
    //System.out.println("\nDu er nu på " + dayCounter + ". dag");
  }

  boolean isDayDone(World world){
    Space[] loc = world.getLocations();
   
    for(int i = 0; i < loc.length; i++){
      if(!(loc[i] instanceof Kontor) && !(loc[i] instanceof Butik)){
        Trash[] trash = loc[i].getTrash();
        
        for(int j = 0; j < trash.length; j++){
          if(trash[j].getAmount() != 0){
            return false;
          }
        }
      }else{        
        if(!(loc[i].getHandled())){
          return false;
        }
      }
    }
    return true;

  }


  public int getDay() {
    return this.dayCounter;
  }

  public Player getPlayer() {
    return player;
  }

  public void makeDone () {
    done = true;
  }
  
  public boolean isDone () {
    return done;
  }
}

