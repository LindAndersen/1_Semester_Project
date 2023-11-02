/* Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.Set;
import java.util.Map;

 abstract class Space extends Node implements DefaultSpace {
  private boolean isHandled;

  Space (String name) {
    super(name);
    isHandled = false;
  }
  
  public void welcome () {
    System.out.println("Du er nu ved "+name);
  }

  public void exits() {
    Set<String> exits = edges.keySet();
    System.out.println("Nuværende udgange fører til");
    for (String exit: exits) {
      System.out.println(" - "+exit);
    }
  }
  
  public void goodbye () {
    //Make some logic to know when u should make room handled, if should be handled invoke toggleHandled() method
  }

  public void showTrash(Trash[] trash) {
    System.out.println("Du kigger rundt og ser ");
    for (Trash t : trash) {
        System.out.printf("- %d %s%n", t.getAmount(), t.getName());
    }
  }
  public void setRoomTrash(){
    
  }
  public Trash[] getTrash(){
    Trash[] trash = new Trash[1];
    return trash;
  }


  //SubtractTrash subtracts trash from room. Catches InsufficientTrashException 
  public boolean subtractTrash(String name, int amount, Trash[] trash) {
    for (Trash t : trash) {
        if (t.getName().equals(name)) {
            try {
                t.subtractTrash(amount);
                return true;
            } catch (InsufficientTrashException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
    }
    return false;
  }

public boolean isCommandReachable(String name, String[] commands) {
    for (String elm : commands) {
        if (elm.equals(name)) {return true;}
    }
    return false;
  }



  public void makeHandled() {
    isHandled = true;
  }
  public void undoHandled(){
    isHandled = false;
  }

  public boolean getHandled() {
    return isHandled;
  }
}
