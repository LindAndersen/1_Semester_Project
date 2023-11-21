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
    registry.register("pickup", new CommandPickup());
    registry.register("buy", new CommandBuy());
    registry.register("recycle", new CommandRecycle());
    registry.register("status", new CommandStatus());
    registry.register("reset", new CommandResetDay(world));
    registry.register("save", new CommandSave(world, context));
    registry.register("load", new CommandLoad());

    //{"exit", "quit", "bye", "go", "help", "pickup", "buy", "recycle"}
  }

  private static void initialWelcome() {
    System.out.println("");
    System.out.println("Stort tillykke! Du er blevet valgt som borgmester for byen! " + "Puha, der er mange opgaver, du skal til at arbejde med… " + "Lad os hjælpe dig lidt i gang!" );
    System.out.println("I dette spil er dit mål at gøre byen til et bæredygtigt sted at bo. Din opgave som borgmester vil være at bruge byens økonomi til at investere i de rigtige beslutninger, der gør byen mere bæredygtig for borgerne og miljøet!");
    System.out.println("Byen har brug for de bedste bæredygtige  løsninger! Er du klar til at påtage dig rollen og hjælpe byen med at blomstre?");
    System.out.println("");
    System.out.println("Byen har også brug for en kærlig hånd, og der er meget skrald, der kan genanvendes... Måske skulle du prøve at tage ud og samle skraldet op et sted, og se hvad der sker?");
    System.out.println("Du kommer rundt ved at bruge 'go', og handlinger for rummet kan findes via 'help', i det rum du befinder dig i");
    System.out.println("");
  }

  private static void mainMenu() {
    do {
      try {
        System.out.println("Hovedmenu\n1. Start new game\n2. Indlæs spil\nBrug tal for at vælge din handling");
        String temp = scanner.nextLine();
        int option = Integer.parseInt(temp);
        if (option == 1) {
          return;
        } else if (option == 2) {
          registry.dispatch("load");
          return;
        } else {
          throw new NumberFormatException();
        }

    } catch (NumberFormatException e) {
      System.out.println("Ikke gyldigt, prøv igen");
    }
    }
    while (true); 
  }

  // private static void exitGame() {
  //   boolean isValid = false;
  //    System.out.println("Vil du gerne gemme dit spil?\n[1] Ja\n[2] Nej");
  //   do {
  //     try {
  //       String temp = scanner.nextLine();
  //       int option = Integer.parseInt(temp);
  //       isValid = true;
  //   } catch (NumberFormatException e) {
  //     System.out.println("Ikke gyldigt, prøv igen");
  //   }
  //   }
  //   while (!isValid); 
  //   System.out.println("Game Over 😥");
  // }
  
  public static void main (String args[]) {
    initRegistry();
    mainMenu();
    
    initialWelcome();
    context.getCurrent().welcome();


    while (context.isDone()==false) {
      System.out.print("> ");
      String line = scanner.nextLine();
      registry.dispatch(line.toLowerCase());
    }

    //exitGame();
  }
 
  public static void setWorld(World loadedWorld) {
    world = loadedWorld;
  }

  public static void setContext(Context loadedContext) {
    context = loadedContext;
    registry = new Registry(context, fallback);
    initRegistry();
  }
}
