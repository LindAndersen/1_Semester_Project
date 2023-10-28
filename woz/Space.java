/* Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.Set;

 abstract class Space extends Node implements DefaultSpace {
  private boolean isHandled;
  Space (String name) {
    super(name);
    isHandled = false;
  }
  
  public void welcome () {
    System.out.println("You are now at "+name);
    Set<String> exits = edges.keySet();
    System.out.println("Current exits are:");
    for (String exit: exits) {
      System.out.println(" - "+exit);
    }
  }
  
  public void goodbye () {
  }

  public void toggleHandled() {
    isHandled = !isHandled;
  }

  public boolean getHandled() {
    return isHandled;
  }
}
