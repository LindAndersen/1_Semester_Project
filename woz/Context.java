/* Context class to hold all context relevant to a session.
 */

class Context {
  Space current;
  boolean done = false;
  
  Context (Space node) {
    current = node;
  }
  
  public Space getCurrent() {
    return current;
  }
  
  public void transition (String direction) {
    Space next = current.followEdge(direction);
    if (next==null) {
      System.out.println("You are confused, and walk in a circle looking for '"+direction+"'. In the end you give up 😩");
    } else {
      current.goodbye();
      current = next;
      current.welcome();
    }
  }
  
  public void makeDone () {
    done = true;
  }
  
  public boolean isDone () {
    return done;
  }
}

