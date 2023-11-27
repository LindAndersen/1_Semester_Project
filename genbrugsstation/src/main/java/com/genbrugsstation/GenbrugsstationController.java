package com.genbrugsstation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class GenbrugsstationController {
    Registry registry = Game.getRegistry();

    @FXML
    private void recycle(MouseEvent event) {
        Button b = (Button) event.getSource();
        String id = b.getId();
        System.out.println(id);
        if (id.equals("btn_recycle_1")) {
            System.out.println("We did recycling 1");
            registry.dispatch("recycle 1");
        } else {
            System.out.println("We did recycling 2");
            registry.dispatch("recycle 2");
        }
        System.out.println("You just recycled!");
        //System.out.println(event.toString());
        //do smt
    }

    @FXML
    private void go(MouseEvent event) {
        String cmd = ((Button)event.getSource()).getId().replace("_", " ");
        System.out.println("You are going to: " + cmd);
        registry.dispatch(cmd);
        //System.out.println(event.toString());
        //do smt

        registry.dispatch("go genbrugsstation");
    }

    @FXML
    private void pickup(MouseEvent event) {
        String cmd = ((Button)event.getSource()).getId().replace("_", " ");
        System.out.println(cmd);
        registry.dispatch(cmd);
        //System.out.println(event.toString());
        //do smt
    }

    @FXML
    private void showMainMenu() {
        System.out.println("You just showed main menu");
    }
}
