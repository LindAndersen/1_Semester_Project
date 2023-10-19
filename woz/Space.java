/* Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.*;

class Space extends Node {
  List<String> commands = new ArrayList<String>();

  Space (String name) {
    super(name);
    SpaceBuilder sp = new SpaceBuilder(name);

  }


  public void welcome () {
    System.out.println("\nDu er nu ved "+name);
    update();
  }

  public void update() {
    System.out.println("-------------------------------------------");
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
    System.out.printf("%nHere will be some information about %s (the room you just left)", name);
  }

  public void addCommand(String cmdName) {
    commands.add(cmdName);
  }

  public boolean isCommandPossible(String cmdName) {
    for (String command : commands) {
      if (command.equals(cmdName)) {return true;}
    }
    return false;
  }

  @Override
  public Space followEdge (String direction) {
    return (Space) (super.followEdge(direction));
  }
}
