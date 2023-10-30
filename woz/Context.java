/* Context class to hold all context relevant to a session.
 */

class Context {
  private Space current;
  private boolean done = false;
  private Player player = new Player("Borgmester");
  private int dayCounter = 0;
  
  Context (Space node) {
    current = node;
  }
  
  public Space getCurrent() {
    return current;
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

