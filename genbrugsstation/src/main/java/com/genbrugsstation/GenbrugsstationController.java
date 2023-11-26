package com.genbrugsstation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class GenbrugsstationController {
    @FXML
    private Button btn_menu;
    @FXML
    private Pane pane_recycle_1;
    @FXML
    private Pane pane_recycle_2;
    @FXML
    private Pane pane_trash_1;
    @FXML
    private Pane pane_trash_2;
    @FXML
    private Pane pane_trash_3;
    @FXML
    private Button btn_go_1;
    @FXML
    private Button btn_go_2;
    @FXML
    private Button btn_go_3;
    @FXML
    private Button btn_go4;
    @FXML
    private Button btn_go_5;

    Registry registry = Game.getRegistry();

    @FXML
    private void recycle() {
        registry.dispatch("recycle 1");
        System.out.println("You just recycled!");
        //System.out.println(event.toString());
        //do smt
    }

    @FXML
    private void go() {
        registry.dispatch("go genbrugsstation");

        System.out.println("You just goed to genbrugsstation");
        //System.out.println(event.toString());
        //do smt
    }

    @FXML
    private void pickup() {
        registry.dispatch("go genbrugsstation");
        registry.dispatch("pickup 1 metalskrot");
        System.out.println("You just picked up");
        //System.out.println(event.toString());
        //do smt
    }

    @FXML
    private void showMainMenu() {
        System.out.println("You just showed main menu");
    }
}
