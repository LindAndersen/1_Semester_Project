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
    registry.register("quit", cmdExit);
    registry.register("bye", cmdExit);
    registry.register("go", new CommandGo());
    registry.register("help", new CommandHelp(registry));
    registry.register("pickup", new CommandPickup());
    registry.register("buy", new CommandBuy());
    registry.register("recycle", new CommandRecycle());
    registry.register("status", new CommandStatus());
    registry.register("reset", new CommandResetDay(world));

    //{"exit", "quit", "bye", "go", "help", "pickup", "buy", "recycle"}
  }
  
  public static void main (String args[]) {
    System.out.println("");
    System.out.println("Stort tillykke! Du er blevet valgt som borgmester for byen! " + "Puha, der er mange opgaver, du skal til at arbejde med… " + "Lad os hjælpe dig lidt i gang!" );
    System.out.println("I dette spil er dit mål at gøre byen til et bæredygtigt sted at bo. Din opgave som borgmester vil være at bruge byens økonomi til at investere i de rigtige beslutninger, der gør byen mere bæredygtig for borgerne og miljøet!");
    System.out.println("Byen har brug for de bedste bæredygtige  løsninger! Er du klar til at påtage dig rollen, investere i de bedste miljøbevidste valg, og hjælpe byen med at blomstre?");
    initRegistry();
    System.out.println("");
    System.out.println("Byen har også brug for en kærlig hånd, og der er meget skrald, der kan genanvendes... Måske skulle du prøve at tage ud og samle skraldet op et sted, og se hvad der sker?");
    System.out.println("Du kommer rundt ved at bruge go, og andre handlinger kan findes via help");
    System.out.println("");
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
