package com.genbrugsstation;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class VillakvarterController {
    private Context context = Game.getContext();
;
    private Player player;

    @FXML
    private Label aviser_label;
    @FXML
    private Label flasker_label;
    @FXML
    private Text feedback_txtField;

    @FXML
    public void initialize() {
        player = context.getPlayer();
        feedback_txtField.setText("Here you will get feedback");
        updateTrash();
    }

    private void updateFeedback(String feedback) {
        feedback_txtField.setText(feedback);
    }

    private void updateTrash() {

        Trash[] trash = context.getCurrent().getTrash();
        for (Trash t : trash) {
            switch (t.getName()) {
                case "aviser":
                    aviser_label.setText("aviser: " + t.getAmount());
                    break;
                case "flasker":
                    flasker_label.setText("flasker: " + t.getAmount());
                    break;
            }
        }
    }


    @FXML
    private void go(MouseEvent event) {
        String id = ((javafx.scene.Node)event.getSource()).getId();
        String location = id.split("_")[1] + "-view";
        try{
            Game.setRoot(location);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void pickup(MouseEvent event) {
        String cmd = ((Button)event.getSource()).getId().replace("_", " ");
        String[] elm = cmd.split(" ");
        System.out.println(cmd);
        if(context == null){
            System.out.println("context er null");
        }else{
            System.out.println("context er ikke null");
        }
        player.pickup(elm[2], 1, context.getCurrent().getTrash(), context);
        updateTrash();
        updateFeedback("Du har samlet 1 " + elm[2] + " op | " + player.getInventory().getItems().get(elm[2]) + " totalt");
    }

    @FXML
    private void showDefaultMenu() {
        System.out.println("You just showed main menu");
        try{
            Game.setRoot("default-menu-view");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
