/* Context class to hold all context relevant to a session.
 */

class Context {
  private Space current;
  private boolean done = false;
  private Player player = new Player("Borgmester");
  private int dayCounter = 1;
  
  Context (Space node) {
    current = node;
  }
  
  public Space getCurrent() {
    return current;
  }

  public void setCurrent(Space newCurrent){
    current = newCurrent;
  }
  
  public void transition (String direction) {
    Space next = (Space) current.followEdge(direction);
    if (next==null) {
      System.out.println("Det var forvirrende, du kunne ikke komme til '"+direction+"'. Måske skulle du prøve at tage til et andet sted?");
    } else {
      current.goodbye();
      current = next;
      current.welcome();
    }
  }

   void resetDay(World world){
    //nulstiller state i hvert rum og inkrementerer dayCounter
    Space[] locations = world.getLocations();//henter lokationerne
    Space kontor;


    for(Space loc : locations){
      if(loc instanceof Park || loc instanceof Rækkehuse || loc instanceof Rådhusplads || loc instanceof Genbrugsstation){
        //kun hvis rummet er en type, der har affald, skal affald resettes
        loc.setRoomTrash();
      }

      loc.undoHandled();//sætter isHandled i hvert rum til 

      if(loc.getName().equals("kontor")){
        setCurrent(loc);
      }
    }
    dayCounter++;
    System.out.println("Du er nu på " + dayCounter + ". dag");

    // setCurrent(kontor);//man "vågner op" i kontoret igen
  }

  boolean isDayDone(World world){
    Space[] loc = world.getLocations();

    for(int i = 0; i < loc.length; i++){
      if(loc[i] instanceof Park || loc[i] instanceof Rækkehuse || loc[i] instanceof Rådhusplads || loc[i] instanceof Genbrugsstation){
        Trash[] trash = loc[i].getTrash();
        
        for(int j = 0; j < trash.length; j++){
          if(loc[i].getTrash()[j].getAmount() != 0){
            return false;
          }
        }

      }else if(loc[i] instanceof Kontor || loc[i] instanceof Butik){
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
    return this.player;
  }

  public void makeDone () {
    done = true;
  }
  
  public boolean isDone () {
    return done;
  }
}

