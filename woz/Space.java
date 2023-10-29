/* Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.Set;

 abstract class Space extends Node implements DefaultSpace {
  private boolean isHandled;
  Trash[] trash;

  Space (String name) {
    super(name);
    isHandled = false;
  }
  
  public void welcome () {
    System.out.println("You are now at "+name);
  }

  public void exits() {
    Set<String> exits = edges.keySet();
    System.out.println("Current exits are:");
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

  public void subtractTrash(String name, int amount, Trash[] trash) {
    for (Trash t : trash) {
        if (t.getName().equals(name)) {
            try {
                t.subtractTrash(amount);
            } catch (InsufficientTrashException e) {
                System.out.println(e.getMessage());
            }
        }
    }
  }

  public void toggleHandled() {
    isHandled = !isHandled;
  }

  public boolean getHandled() {
    return isHandled;
  }
}
