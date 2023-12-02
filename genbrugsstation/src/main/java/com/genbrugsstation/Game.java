package com.genbrugsstation;

import java.util.Objects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * JavaFX App
 */

public class Game extends Application {
  private static Scene scene;
  static World    world;
  static Context  context;
  static Butikdata butikdata = new Butikdata();
  static String prevView = null;
  static String currentView;
  
    @Override
    public void start(Stage stage) throws IOException {
        currentView = "main-menu-view";
        scene = new Scene(loadFXML(currentView));
        Stagestore.stage = stage;
        stage.setTitle("Main menu");
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(Game.class.getResource(fxml + ".fxml")));
        return fxmlLoader.load();
    }

    public static void setRoot(String rootNode) throws IOException {
      prevView = currentView;
      Space[] loc = world.getLocations();
      String title = rootNode.split("-")[0];
      for(Space s : loc) {
        if ((s.getName().toLowerCase()).equals(title.trim().toLowerCase())) {
          context.setCurrent(s);
          if((s.getName().trim().toLowerCase()).equals("butik") && (title.trim().toLowerCase().equals("opgraderinger"))){
            context.setCurrent(s);
          }
          currentView = rootNode;
          //System.out.println("sætter current til "+ context.getCurrent().getName());
        }
      }
      
      scene = new Scene(loadFXML(rootNode));
      Stagestore.stage.setScene(scene);
      System.out.println(title);
      Stagestore.stage.setTitle(title);
      Stagestore.stage.centerOnScreen();
      Stagestore.stage.show();

    }

  public static void main (String[] args) {
    newGame();
    launch();
  }

  public static void newGame() {
    world = new World();
    context = new Context(world.getEntry());
  }

  public static void save_game() {
    String filename = "test";
      try {
          boolean didCreateSaves = new File("saves").mkdirs();
          new File("saves\\" + filename).mkdirs();
          System.out.println((didCreateSaves ? "Creating save folder" : ""));
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

  public static void load_game() throws ClassNotFoundException, IOException {
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
            World world = (World) worldIn.readObject();
            Context context = (Context) contextIn.readObject();

            setWorld(world);
            setContext(context);

            // System.out.println(worldIn != null ? "Did not fully load world..." : "");
            // System.out.println(contextIn != null ? "Did not fully load context..." : "");
          }
        }
        setRoot("kontor-view");
        return;
      }

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


 
  public static void setWorld(World loadedWorld) {
    world = loadedWorld;
  }

  public static void setContext(Context loadedContext) {
    context = loadedContext;
  }

  public static Context getContext() {
    return context;
  }

  public static Butikdata getButikdata() {
    return butikdata;
  }
}
