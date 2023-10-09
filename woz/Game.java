/* Main class for launching the game
 */

import java.util.Scanner;

class Game {
  static World    world    = new World();
  static Context  context  = new Context(world.getEntry());
  static Command  fallback = new CommandUnknown();
  static Registry registry = new Registry(context, fallback);
  static Scanner  scanner  = new Scanner(System.in);
  
  private static void initRegistry () {
    Command cmdExit = new CommandExit();
    registry.register("exit", cmdExit);
    registry.register("quit", cmdExit);
    registry.register("bye", cmdExit);
    registry.register("go", new CommandGo());
    registry.register("help", new CommandHelp(registry));
  }
  
  public static void main (String args[]) {
    System.out.println("Welcome to the World of Zuul!");
    
    initRegistry();
    context.getCurrent().welcome();
    
    while (context.isDone()==false) {
      System.out.print("> ");
      String line = scanner.nextLine();
      registry.dispatch(line);
    }
    System.out.println("Game Over 😥");
  }
}
