package com.genbrugsstation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DomainMain {
  World    world;
  Context  context;

  DomainMain() {
    world = new World();
    context = new Context(world.getEntry());
  }


  public void newGame() {
    world = new World();
    context = new Context(world.getEntry());
  }

  //Sets save folder name to "test"
  //Writes world and context to a file
  public void save_game() {
    String filename = "test";
      try {
        //If parent folder "saves" to saves doesnt exist it will be created
          boolean didCreateSaves = new File("saves").mkdirs();
          new File("saves\\" + filename).mkdirs();
          System.out.println((didCreateSaves ? "Creating save folder" : ""));
          //System.getProperty() gets local path
          String pathToSaves = System.getProperty("user.dir") + "\\saves";
          System.out.printf("Will be stored at: %n%s%n", pathToSaves);
          FileOutputStream worldFile = new FileOutputStream(pathToSaves + "\\" + filename + "\\world.ser");
          FileOutputStream contextFile = new FileOutputStream(pathToSaves + "\\" + filename + "\\context.ser");
          ObjectOutputStream worldOut = new ObjectOutputStream(worldFile);
          ObjectOutputStream contextOut = new ObjectOutputStream(contextFile);

          worldOut.writeObject(world);
          contextOut.writeObject(context);
          worldOut.close();
          contextOut.close();
          worldFile.close();
          contextFile.close();

          System.out.printf("Completed save with name: %s%n", filename);

      } catch (IOException e) {
          e.printStackTrace();
      }
  }

  //Checks, via printSaveDir, if save folder and any saves exists first, else return
  //Retrieves saved files (loads) and sets the current world and context to these
  //Changes view to kontor-view.fxml
  public void load_game() throws ClassNotFoundException, IOException {
        File[] saves = printSaveDir();
        if (saves == null) {
          System.out.println("Der er ingen gemte spil :'(");
          return; 
        }

        String saveName = "test";

        String pathToSaves = System.getProperty("user.dir") + "\\saves";
        FileInputStream worldFile = new FileInputStream(pathToSaves + "\\" + saveName + "\\world.ser");
        FileInputStream contextFile = new FileInputStream(pathToSaves + "\\" + saveName + "\\context.ser");
        try (ObjectInputStream worldIn = new ObjectInputStream(worldFile)) {
          try (ObjectInputStream contextIn = new ObjectInputStream(contextFile)) {
            World loadedWorld = (World) worldIn.readObject();
            Context loadedContext = (Context) contextIn.readObject();

            //assertThat(context == loadedContext).isFalse()

            world = loadedWorld;
            context = loadedContext;

            // System.out.println(worldIn != null ? "Did not fully load world..." : "");
            // System.out.println(contextIn != null ? "Did not fully load context..." : "");
          }
        }
      }

  //Returns list of folders inside save dir or null if no saves are present
    private static File[] printSaveDir() {
      File[] saves = null;
        try {
            File saveDir = new File("saves");
            saves = saveDir.listFiles();
        } catch (NullPointerException e) {
            System.out.println("Creating save folder");
            new File("saves").mkdirs();
        }

        return saves;
    }

  public Context getContext() {
    return context;
  }
}
