/* Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.*;

class Space extends Node {
  List<String> commands = new ArrayList<String>();

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

    System.out.println("Rumhandlinger");
    for (String command : commands) {
      System.out.printf(" - %s%n", command);
    }
  }
  
  public void goodbye () {
    System.out.println("Here will be some information about the room you just left");
  }

    public void addCommand(String cmdName) {
    commands.add(cmdName);
  }

  @Override
  public Space followEdge (String direction) {
    return (Space) (super.followEdge(direction));
  }
}
