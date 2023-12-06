package com.genbrugsstation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

public class Game extends Application {
  private Scene scene;
  
    @Override
    public void start(Stage stage) {
      Stagestore.stage = stage;
      SharedGUIFunc.setRootFromString("main-menu-view");
    }

  private static void newGame() {
    DomainMain domain = new DomainMain();
    domain.newGame();
    new SharedGUIFunc(domain);
  }

  public static void main (String[] args) {
    newGame(); //Initializes a new DomainMain "domain" and runs domain.newGame()
    launch(); //launch runs start()
  }
}
