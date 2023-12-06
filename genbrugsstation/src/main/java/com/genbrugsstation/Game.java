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
  static String prevView = null;
  static String currentView;
  
    @Override
    public void start(Stage stage) {
        try {
            currentView = "main-menu-view";
            scene = new Scene(loadFXML(currentView));
            Stagestore.stage = stage;
            stage.setTitle("Main menu");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    //hjælpemetode til setRoot
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(Game.class.getResource(fxml + ".fxml")));
        return fxmlLoader.load();
    }

    //holder styr på lokationen ift. affald, og derefter loader den scene, der gives som
    //argument i metodekald
    public static void setRoot(String rootNode) {
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
        }
      }

      try {
          scene = new Scene(loadFXML(rootNode));
          Stagestore.stage.setScene(scene);
          System.out.println(title);
          Stagestore.stage.setTitle(title);
          Stagestore.stage.centerOnScreen();
          Stagestore.stage.show();
      }catch (IOException e){
          System.out.println(e.getMessage());
          e.printStackTrace();
      }

    }

  public static void main (String[] args) {
    newGame();
    //launch runs start()
    launch();
  }

  static void newGame() {
    world = new World();
    context = new Context(world.getEntry());
  }

  //Sets save folder name to "test"
  //Writes world and context to a file
  static void save_game() {
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
          FileOutputStream butikdataFile = new FileOutputStream(pathToSaves + "\\" + filename + "\\butikdata.ser");
          ObjectOutputStream worldOut = new ObjectOutputStream(worldFile);
          ObjectOutputStream contextOut = new ObjectOutputStream(contextFile);
          ObjectOutputStream butikdataOut = new ObjectOutputStream(butikdataFile);

          worldOut.writeObject(world);  
          contextOut.writeObject(context);
          butikdataOut.writeObject(Butikdata.getUpgrades());

          contextOut.flush();
          
          worldOut.close();
          contextOut.close();
          butikdataOut.close();
          worldFile.close();
          contextFile.close();
          butikdataFile.close();

          System.out.printf("Completed save with name: %s%n", filename);

      } catch (IOException e) {
          e.printStackTrace();
      }
  }

  //Checks, via printSaveDir, if save folder and any saves exists first, else return
  //Retrieves saved files (loads) and sets the current world and context to these
  //Changes view to kontor-view.fxml
    static void load_game() throws ClassNotFoundException, IOException {
        File[] saves = printSaveDir();
        if (saves == null) {
          System.out.println("Der er ingen gemte spil :'(");
          return; 
        }

        String saveName = "test";

        String pathToSaves = System.getProperty("user.dir") + "\\saves";
        FileInputStream worldFile = new FileInputStream(pathToSaves + "\\" + saveName + "\\world.ser");
        FileInputStream contextFile = new FileInputStream(pathToSaves + "\\" + saveName + "\\context.ser");
        FileInputStream butikdataFile = new FileInputStream(pathToSaves + "\\" + saveName + "\\butikdata.ser");
        try (ObjectInputStream worldIn = new ObjectInputStream(worldFile)) {
          World loadedWorld = (World) worldIn.readObject();
          world = loadedWorld;
        }
        try (ObjectInputStream contextIn = new ObjectInputStream(contextFile)) {
          Context loadedContext = (Context) contextIn.readObject();
          context = loadedContext;

          // Access the Player and Inventory objects
          Player player = context.getPlayer();
          Inventory inventory = player.getInventory();

          // Print some information from the deserialized objects
          System.out.println("Player Name: " + player.getName());
          System.out.println("Player XP: " + player.getXP());
          System.out.println("Inventory Items: " + inventory.getItems());
        }
        try (ObjectInputStream butikdataIn = new ObjectInputStream(butikdataFile)) {
          String[] loadedButikdata = (String[]) butikdataIn.readObject();
          Butikdata.setUpgrades(loadedButikdata);
        }
        setRoot("kontor-view");
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

  public static Context getContext() {
    return context;
  }
}
