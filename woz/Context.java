/* Context class to hold all context relevant to a session.
 */

class Context {
  private boolean firstTime = true;
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

  //En message for det første rum, du kommer ind i, ved spillet :D
  public void firstRoomMessage() {
      System.out.println("Puha, der kan muligvis være meget skrald rundt omkring...");
      System.out.println("Når du bruger 'pickup' i et rum, kan du få et overblik, hvis der befinder sig skrald i rummet!");
      System.out.println("Lad os tjekke det! Prøv at bruge 'pickup' i rummet.");
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

      //displayer igennem hele første dag, for følgende; Butik, Genbrugsstation & Kontor.
      if (dayCounter == 1) {
        if (current instanceof Butik) { //tjekker instance af butikken
          Butik butik = (Butik)current; //downcaster
          butik.firstDayWelcome(); //printer firstTimeWelcome, når det er første dag.
        }
        else if (current instanceof Genbrugsstation) { //tjekker instance af genbrugsstationen
          Genbrugsstation genbrugsstation = (Genbrugsstation)current; //downcaster
          genbrugsstation.firstDayWelcome(); //printer firstTimeWelcome, når det er første dag.
        }
        else if (current instanceof Kontor) { //tjekker instance af kontor.
          Kontor kontor = (Kontor)current; //downcaster
          kontor.firstDayWelcome(); //printer firstTimeWelcome, når det er første dag.
        }
        else {
          if (firstTime) {
            firstRoomMessage();
            firstTime = false;
        }
          else {
            System.out.println("Du kan bruge 'help' for at se tilgængelige commands i rummet!");
          }
        }
      }
    }
  
  int getDay() {
    return this.dayCounter;
  }

  Player getPlayer() {
    return this.player;
  }

  void incrementDayCounter() {
    this.dayCounter++;
  }

  void resetDay() {

  }

  public void makeDone () {
    done = true;
  }
  
  public boolean isDone () {
    return done;
  }
}

