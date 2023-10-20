/* Context class to hold all context relevant to a session.
 */

class Context {

  private Space current;
  private boolean done = false;

  
  private int day = 1;

  Context (Space node) {
    current = node;
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
    
    transition("kontor");//man "vågner op" i kontoret igen

    day++;
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

  //------------------------------------------------------------------------------------------
  
 
  
  public Space getCurrent() {
    return current;
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

}

