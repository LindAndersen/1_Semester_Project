/* Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.Set;

 abstract class Space extends Node implements DefaultSpace {
  Space (String name) {
    super(name);
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
}
