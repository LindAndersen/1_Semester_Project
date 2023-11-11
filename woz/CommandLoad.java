import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

class CommandLoad extends BaseCommand implements Command {
    CommandLoad() {
        this.description = "Indlæs et gemt spil";
    }

    public void execute (Context context, String command, String parameters[]) {
        if (guardEq(parameters, 0)) {
          System.out.println("Her du skal du kun bruge \"load\"");
          return;
        }
        try {
          load();
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }
    }




    private static void load() throws ClassNotFoundException {
        File[] saves = printSaveDir();
        if (saves == null) {
          System.out.println("Der er ingen gemte spil :'(");
          return; 
        }

        System.out.println("Hvilket spil vil du gerne indlæse?");
        do {
          Scanner scanner = new Scanner(System.in);
          try {
            int nSave = scanner.nextInt();
            //int nSave = Integer.parseInt(temp);
            if (nSave > saves.length || nSave < 1) {
              scanner.close();
              throw new NumberFormatException();
            }
            //Decrement by 1 so it represents an index
            nSave--;
            String pathToSaves = System.getProperty("user.dir") + "\\saves";
            FileInputStream file = new FileInputStream(pathToSaves + "\\" + saves[nSave].getName());
            ObjectInputStream in = new ObjectInputStream(file);

            World world = (World) in.readObject();
            Context context = (Context) in.readObject();

            Game.setWorld(world);
            Game.setContext(context);

            in.close();
            file.close();


        } catch (NumberFormatException | NoSuchElementException e) {
          System.out.println("Ikke gyldigt, prøv igen");
        } catch (IOException e) {
          e.printStackTrace();
          break;
        }

        }
        while (true);
      }

    private static File[] printSaveDir() {
      File[] saves = null;
        try {
            File saveDir = new File("saves");
            saves = saveDir.listFiles();
            int count = 1;
            for (File save : saves) {
            System.out.printf("[%d] %s%n", count, save.getName());
            count++;
            } 
        } catch (NullPointerException e) {
            System.out.println("Creating save folder");
            new File("saves").mkdirs();
        }

        return saves;
    }
}