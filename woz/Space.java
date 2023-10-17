/* Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.Set;

class Space extends Node {
  Space (String name) {
    super(name);
  }

  public void welcome () {
    System.out.println("Du er nu ved "+name);
    Set<String> exits = edges.keySet();
    System.out.println("Du kan gå mod:");
    for (String exit: exits) {
      System.out.println(" - "+exit);
    }
  }

  public void roomActions() {
    System.out.println("Rumhandlinger\n - pickup");
  }
  
  public void goodbye () {
  }

  @Override
  public Space followEdge (String direction) {
    return (Space) (super.followEdge(direction));
  }
}
