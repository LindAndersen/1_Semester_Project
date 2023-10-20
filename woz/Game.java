/* Main class for launching the game
 */

import java.util.Scanner;

class Game {
  static World    world    = new World();
  static Player player = new Player(); 
  static Context  context  = new Context(world.getEntry(), player);
  static Command  fallback = new CommandUnknown();
  static Registry registry = new Registry(context, fallback);
  static Scanner  scanner  = new Scanner(System.in);

  
  private static void initRegistry () {
    Command cmdExit = new CommandExit();
    registry.register("exit", cmdExit);
    registry.register("quit", cmdExit);
    registry.register("bye", cmdExit);
    registry.register("pickup", new CommandRoomAction("Saml skrald op"));
    registry.register("sell", new CommandRoomAction("Sælg dit skrald"));
    registry.register("buy", new CommandRoomAction("Køb udvidelser til din by"));
    registry.register("hint", new CommandRoomAction("Få hjælp til at forstå dine muligheder"));
    registry.register("status", new CommandRoomAction("Vis en statusoversigt over din by"));
    registry.register("go", new CommandGo());
    registry.register("help", new CommandHelp(registry));
    registry.register("reset", new CommandResetDay());

  }
  
  public static void main (String args[]) {
    System.out.println("Velkommen til din by, her er du borgmester! Gør dit bedste for at tage bæredygtige beslutninger!"); 
    
    initRegistry();
    context.getCurrent().welcome();

    while (context.isDone() == false) {
     
      System.out.print("> ");
      String line = scanner.nextLine();
      registry.dispatch(line);
     
     // ------------------------------------------------------------------------------------------------------------
      if(context.isDayDone(world.park, world.hospital, world.bymidte, world.butik, world.genbrugsstation)){
        System.out.println("Der er ikke mere, du kan gøre i dag. Du kan gå til næste dag ved at skrive 'reset'.");
      }
      //------------------------------------------------------------------------------------------------------------
    }
    System.out.println("Game Over.");
  }
}
