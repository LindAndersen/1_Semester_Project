/* Main class for launching the game
 */

import java.util.Scanner;

class Game {
  static World    world    = new World();
  static Context  context  = new Context(world.getEntry());
  static Command  fallback = new CommandUnknown();
  static Registry registry = new Registry(context, fallback);
  static Scanner  scanner  = new Scanner(System.in);
  //tilføjet - -----------------------------------------------------------------------------------------------------------
  static Player player = new Player(); 
  //----------------------------------------------------------------------------------------------------------------------
  
  private static void initRegistry () {
    Command cmdExit = new CommandExit();
    registry.register("exit", cmdExit);
    registry.register("quit", cmdExit);
    registry.register("bye", cmdExit);
    registry.register("go", new CommandGo());
    registry.register("help", new CommandHelp(registry));
  }
  
  public static void main (String args[]) {
    int day = 1;
    System.out.println("Welcome to the World of Zuul!");
    
    initRegistry();
    context.getCurrent().welcome();

    //tilføjet start for tests ------------------------------------------------------------------------------------------------------
    player.addPoints(28);
    player.levelUp(player.getPoints());
    System.out.println("level: " + player.getLevel() + ", points: " + player.getPoints() + ", money: " + player.getMoney());
    // tilføjet slut ------------------------------------------------------------------------------------------------------

    while (context.isDone() == false) {
     
      System.out.print("> ");
      String line = scanner.nextLine();
      registry.dispatch(line);
       //---------------------------------------------------- test, men dette skal afgøre om dagen skal skifte, nyt skrald skal 
      //---------------------------------------------------- placeres og nulstille de bolske værdier der afgør om dagen er done
      System.out.println("day is done: " + context.isDayDone());
      //----------------------------------------------------
    }
    System.out.println("Game Over.");
  }
}
