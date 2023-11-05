/* Main class for launching the game
 */

import java.util.Scanner;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

class Game {
  static World    world    = new World();
  static Context  context  = new Context(world.getEntry());
  static Command  fallback = new CommandUnknown();
  static Registry registry = new Registry(context, fallback);
  static Scanner  scanner  = new Scanner(System.in);
  
  private static void initRegistry () {
    Command cmdExit = new CommandExit();
    registry.register("exit", cmdExit);
    registry.register("go", new CommandGo());
    registry.register("help", new CommandHelp(registry));
    registry.register("pickup", new CommandPickup());
    registry.register("buy", new CommandBuy());
    registry.register("recycle", new CommandRecycle());
    registry.register("status", new CommandStatus());
    registry.register("reset", new CommandResetDay(world));
    registry.register("cheat", new Commandcheat());

    //{"exit", "quit", "bye", "go", "help", "pickup", "buy", "recycle"}
  }
  
  public static void main (String args[]) {
    System.out.println("\n꒷꒦꒷︶˚︶︶꒷꒦˚꒦꒷︶˚︶꒷꒦˚︶˚︶︶꒷꒦꒷︶˚︶︶꒷꒦˚꒦꒷︶˚︶︶꒷꒦˚︶˚︶꒷꒦");
    System.out.println("                     ꧁SKRALDEBY꧂ \n ");
    System.out.println("꒷꒦꒷︶˚︶︶꒷꒦˚꒦꒷︶˚︶꒷꒦˚︶˚︶︶꒷꒦꒷︶˚︶︶꒷꒦˚꒦꒷︶˚︶︶꒷꒦˚︶˚︶꒷꒦");
    System.out.println("\nStort tillykke! Du er blevet valgt som borgmester for byen!\n" +
            "Puha, der er mange opgaver, du skal til at arbejde med… Lad os hjælpe dig lidt i gang!\n" +
            "I dette spil er dit mål at gøre byen til et bæredygtigt sted at bo." + "Din opgave som borgmester vil være at investere i de bedste bæredygtige løsninger for borgerne og miljøet!\n" +
            "Er du klar til at påtage dig rollen og hjælpe byen med at blomstre?\n" +
            "\n" +
            "\"Byen har også brug for en kærlig hånd, og der er meget skrald, der kan genanvendes... Måske skulle du prøve at tage ud og samle skraldet op et sted, og se hvad der sker?\"\n" +
            "Du kommer rundt ved at bruge 'go', og handlinger for rummet kan findes via 'help', i det rum du befinder dig i");
    initRegistry();
    context.getCurrent().welcome();

    while (context.isDone()==false) {
      System.out.print("> ");
      String line = scanner.nextLine();
      registry.dispatch(line.toLowerCase());

      if(context.isDayDone(world)){
        System.out.println("Der er ikke mere at lave i dag. Du kan starte næste dag ved at skrive 'reset'");
      }
    }
    System.out.println("Game Over 😥");
  }
}
