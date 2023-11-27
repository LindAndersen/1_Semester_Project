package com.example.kontorgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    static World world = new World();
    static Context context = new Context(world.getEntry());

    @Override
    public void start(Stage stage) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("menu-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 314, 198);
            stage.setTitle("Skraldeby");
            stage.setScene(scene);
            stage.show();
            context.getCurrent().welcome();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
      launch();
      System.out.println("Game Over 😥");
  }
}