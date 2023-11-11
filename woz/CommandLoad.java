import java.io.File;
import java.util.Scanner;

class CommandLoad extends BaseCommand implements Command {
    CommandLoad() {
        this.description = "Indlæs et gemt spil";
    }

    public void execute (Context context, String command, String parameters[]) {
        
    }




    private static void load(int option) {
        printSaveDir();
        System.out.println("Hvilket spil vil du gerne indlæse?");
        boolean isValid = false;
        do {
          Scanner scanner = new Scanner(System.in);
          try {
            String temp = scanner.nextLine();
            int nSave = Integer.parseInt(temp);
            isValid = true;
        } catch (NumberFormatException e) {
          System.out.println("Ikke gyldigt, prøv igen");
          scanner.close();
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
}