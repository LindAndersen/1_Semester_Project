package com.genbrugsstation;

import java.util.Objects;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */

public class Game extends Application {
  private static Scene scene;
  static World    world;
  static Context  context;
  static Butikdata butikdata = new Butikdata();
  
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main-menu-view"));
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
      Space[] loc = world.getLocations();
      String title = rootNode.split("-")[0];
      for(Space s : loc) {
        if ((s.getName().toLowerCase()).equals(title.trim().toLowerCase())) {
          context.setCurrent(s);
          if((s.getName().trim().toLowerCase()).equals("butik") && (title.trim().toLowerCase().equals("opgraderinger"))){
            context.setCurrent(s);
          }
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
