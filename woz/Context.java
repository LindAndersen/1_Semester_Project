/* Context class to hold all context relevant to a session.
 */

class Context {
  private Space current;
  private boolean done = false;
  private boolean roomHandled = false;

  
  Context (Space node) {
    current = node;
  }
  
  public Space getCurrent() {
    return current;
  }

  public void roomHandler() {
    System.out.println("item picked up wuhu");
    makeRoomHandled();
  }
  
  public void transition (String direction) {
    Space next = current.followEdge(direction);
    if (next==null) {
      System.out.println("You are confused, and walk in a circle looking for '"+direction+"'. In the end you give up 😩");
    } else {
      current.goodbye();
      current = next;
      current.welcome();
      current.roomActions();
    }
  }
  
  public void makeDone () {
    done = true;
  }
  
  public boolean isDone () {
    return done;
  }

  public boolean isRoomHandled() {
    return roomHandled;
  }

  public void makeRoomHandled() {
    roomHandled = true;
  }
}

