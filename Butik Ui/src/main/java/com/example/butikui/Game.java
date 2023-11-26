package com.example.butikui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

import java.io.IOException;

public class Game extends Application {
    static World    world    = new World();
    static Context  context  = new Context(world.getEntry());
    static Command  fallback = new CommandUnknown();
    static Registry registry = new Registry(context, fallback);
    static Scanner  scanner  = new Scanner(System.in);

    private static Butikdata butikdata = new Butikdata();

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

        //{"exit", "quit", "bye", "go", "help", "pickup", "buy", "recycle"}
    }

    public static Butikdata getButikdata() {
        return butikdata;
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("Villakvarter.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        fxmlLoader.setController(this);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        System.out.println("\n꒷꒦꒷︶˚︶︶꒷꒦˚꒦꒷︶˚︶꒷꒦˚︶˚︶︶꒷꒦꒷︶˚︶︶꒷꒦˚꒦꒷︶˚︶︶꒷꒦˚︶˚︶꒷꒦");
        System.out.println("                     ꧁SKRALDEBY꧂ \n ");
        System.out.println("꒷꒦꒷︶˚︶︶꒷꒦˚꒦꒷︶˚︶꒷꒦˚︶˚︶︶꒷꒦꒷︶˚︶︶꒷꒦˚꒦꒷︶˚︶︶꒷꒦˚︶˚︶꒷꒦");
        System.out.println("\nStort tillykke! Du er blevet valgt som borgmester for byen!\n" +
                "Puha, der er mange opgaver, du skal til at arbejde med… Lad os hjælpe dig lidt i gang!\n" +
                "I dette spil er dit mål at gøre byen til et bæredygtigt sted at bo." + "Din opgave som borgmester vil være at investere i de bedste bæredygtige løsninger for borgerne og miljøet!\n" +
                "Er du klar til at påtage dig rollen og hjælpe byen med at blomstre?\n" +
                "\n" +
                "\"Byen har også brug for en kærlig hånd, og der er meget skrald, der kan genanvendes... Måske skulle du prøve at tage ud og samle skraldet op et sted, og se hvad der sker?\"\n" +
                "Du kommer rundt ved at bruge 'go', og handlinger for rummet kan findes via 'help', i det rum du befinder dig i");
        initRegistry();
        context.getCurrent().welcome();

    }


    public static void main(String[] args) {
        launch();
    }
}