package com.genbrugsstation;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class GenbrugsstationController {
    Registry registry = Game.getRegistry();
    Player player = Game.getContext().getPlayer();

    @FXML
    private Label metalskrot_label;
    @FXML
    private Label batterier_label;
    @FXML
    private Label plastik_label;
    @FXML
    private Text feedback_txtField;

    @FXML
    public void initialize() {
        registry.dispatch("go genbrugsstation");

        //feedback_txtField.setStyle("-fx-text-fill: black; -fx-font-size: 24px;");
        feedback_txtField.setText("Here you will get feedback");

        updateTrash();
    }

    private void updateFeedback(String feedback) {
        feedback_txtField.setText(feedback);
    }

    private void updateTrash() {
        Trash[] trash = Game.getContext().getCurrent().getTrash();
        for (Trash t : trash) {
            switch (t.getName()) {
                case "metalskrot" : 
                    metalskrot_label.setText("Metalskrot: " + t.getAmount());
                    break;
                case "batterier" : 
                    batterier_label.setText("Batterier: " + t.getAmount());
                    break;
                case "plastik" :
                    plastik_label.setText("Plastik: " + t.getAmount());
                    break;
            }
        }
    }

    @FXML
    private void recycle(MouseEvent event) {
        int prexp, premoney, postxp, postmoney;
        prexp = player.getXP();
        premoney = player.getMoney();

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

        postxp = player.getXP();
        postmoney = player.getMoney();

        updateFeedback("Du fik: " + Integer.toString(postmoney-premoney) + " penge og " + Integer.toString(postxp-prexp) + " XP");

        System.out.println("You just recycled!");
        //System.out.println(event.toString());
        //do smt
    }

    @FXML
    private void go(MouseEvent event) throws IOException {
        String id = ((javafx.scene.Node)event.getSource()).getId();
        String location = id.split("_")[1] + "-view";
        
        Game.setRoot(location);
    }

    @FXML
    private void pickup(MouseEvent event) {
        String cmd = ((Button)event.getSource()).getId().replace("_", " ");
        String[] elm = cmd.split(" ");
        System.out.println(cmd);
        registry.dispatch(cmd);
        //System.out.println(event.toString());
        //do smt
        updateTrash();
        updateFeedback("Du har samlet 1 " + elm[2] + " op | " + player.getInventory().getItems().get(elm[2]) + " totalt");
    }

    @FXML
    private void showMainMenu() {
        System.out.println("You just showed main menu");
    }
}
