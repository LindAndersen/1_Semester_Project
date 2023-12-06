package com.genbrugsstation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

public class Game extends Application {
  private Scene scene;
  static DomainMain domain;
  
    @Override
    public void start(Stage stage) {
      Stagestore.stage = stage;
      SharedGUIFunc.setRootFromString("main-menu-view");
    }

  public static void main (String[] args) {
    domain = new DomainMain();
    domain.newGame();
    launch(); //launch runs start()
  }
}
