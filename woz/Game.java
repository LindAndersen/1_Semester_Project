/* Main class for launching the game
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;

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

  private static void initialWelcome() {
    System.out.println("");
    System.out.println("Stort tillykke! Du er blevet valgt som borgmester for byen! " + "Puha, der er mange opgaver, du skal til at arbejde med… " + "Lad os hjælpe dig lidt i gang!" );
    System.out.println("I dette spil er dit mål at gøre byen til et bæredygtigt sted at bo. Din opgave som borgmester vil være at bruge byens økonomi til at investere i de rigtige beslutninger, der gør byen mere bæredygtig for borgerne og miljøet!");
    System.out.println("Byen har brug for de bedste bæredygtige  løsninger! Er du klar til at påtage dig rollen og hjælpe byen med at blomstre?");
    initRegistry();
    System.out.println("");
    System.out.println("Byen har også brug for en kærlig hånd, og der er meget skrald, der kan genanvendes... Måske skulle du prøve at tage ud og samle skraldet op et sted, og se hvad der sker?");
    System.out.println("Du kommer rundt ved at bruge 'go', og handlinger for rummet kan findes via 'help', i det rum du befinder dig i");
    System.out.println("");
  }

  private static void load(int option) {
    printSaveDir();
    System.out.println("Hvilket spil vil du gerne indlæse?");
    boolean isValid = false;
    do {
      try {
        String temp = scanner.nextLine();
        int nSave = Integer.parseInt(temp);
        isValid = true;
    } catch (NumberFormatException e) {
      System.out.println("Ikke gyldigt, prøv igen");
    }
    }
    while (!isValid); 
  }

  private static void printSaveDir() {
    try {
      File saveDir = new File("saves");
      File[] saves = saveDir.listFiles();
      int count = 0;
      for (File save : saves) {
        System.out.printf("[%d] %s", count, save.getName());
        count++;
      } 
    } catch (NullPointerException e) {
      System.out.println("Creating save folder");
      new File("saves").mkdirs();
    }
  }

  private static void mainMenu() {
    boolean isValid = false;
    do {
      try {
        System.out.println("Hovedmenu\n1. Start new game\n2. Indlæs spil\nBrug tal for at vælge din handling");
        String temp = scanner.nextLine();
        int option = Integer.parseInt(temp);
        load(option);
        isValid = true;
    } catch (NumberFormatException e) {
      System.out.println("Ikke gyldigt, prøv igen");
    }
    }
    while (!isValid); 
  }

  private static void exitGame() {
    boolean isValid = false;
     System.out.println("Vil du gerne gemme dit spil?\n[1] Ja\n[2] Nej");
    do {
      try {
        String temp = scanner.nextLine();
        int option = Integer.parseInt(temp);
        if (1 > option || 2 < option) {
          throw new NumberFormatException();
      }
        isValid = true;
    } catch (NumberFormatException e) {
      System.out.println("Ikke gyldigt, prøv igen");
    }
    }
    while (!isValid); 
    System.out.println("Game Over 😥");
  }
  
  public static void main (String args[]) {
    mainMenu();
    
    initialWelcome();
    context.getCurrent().welcome();


    while (context.isDone()==false) {
      System.out.print("> ");
      String line = scanner.nextLine();
      registry.dispatch(line.toLowerCase());
    }

    exitGame();
  }
}
