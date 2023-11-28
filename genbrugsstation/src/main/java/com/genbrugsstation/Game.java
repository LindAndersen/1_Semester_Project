package com.genbrugsstation;

import java.util.Scanner;
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
  static World    world    = new World();
  static Context  context  = new Context(world.getEntry());
  static Command  fallback = new CommandUnknown();
  static Registry registry = new Registry(context, fallback);
  static Scanner  scanner  = new Scanner(System.in);
  static Butikdata butikdata = new Butikdata();
  
  private static void initRegistry () {
    Command cmdExit = new CommandExit();
    registry.register("exit", cmdExit);
    registry.register("go", new CommandGo());
    registry.register("help", new CommandHelp(registry));
    registry.register("pickup", new CommandPickup());
    registry.register("buy", new CommandBuy());
    registry.register("recycle", new CommandRecycle());
    registry.register("status", new CommandStatus());
    registry.register("reset", new CommandResetDay(world));
    registry.register("save", new CommandSave(world, context));
    registry.register("load", new CommandLoad());

    //{"exit", "quit", "bye", "go", "help", "pickup", "buy", "recycle"}
  }

  @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("menu-view"));
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
  
  public static void main (String args[]) {
    initRegistry();
    launch();
  }
 
  public static void setWorld(World loadedWorld) {
    world = loadedWorld;
  }

  public static void setContext(Context loadedContext) {
    context = loadedContext;
    registry = new Registry(context, fallback);
    initRegistry();
  }

  public static Registry getRegistry() {
    return registry;
  }

  public static Context getContext() {
    return context;
  }

  public static Butikdata getButikdata() {
    return butikdata;
  }
}
