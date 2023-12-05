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
  static String prevView = null;
  static String currentView;
  static Scene scene;
  static DomainMain domain;
  
    @Override
    public void start(Stage stage) {
        try {
            domain = new DomainMain();
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

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(Game.class.getResource(fxml + ".fxml")));
        return fxmlLoader.load();
    }

    public static void setRoot(String rootNode) {
      prevView = currentView;
      Space[] loc = domain.world.getLocations();
      String title = rootNode.split("-")[0];
      for(Space s : loc) {
        if ((s.getName().toLowerCase()).equals(title.trim().toLowerCase())) {
          domain.context.setCurrent(s);
          if((s.getName().trim().toLowerCase()).equals("butik") && (title.trim().toLowerCase().equals("opgraderinger"))){
            domain.context.setCurrent(s);
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
    domain.newGame();
    //launch runs start()
    launch();
  }
}
