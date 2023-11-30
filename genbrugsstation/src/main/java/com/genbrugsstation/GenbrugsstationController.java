package com.genbrugsstation;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class GenbrugsstationController {
    private Context context;
    private Player player;

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
        context = Game.getContext();
        updateTrash();
        player = context.getPlayer();
        updateFeedback("Here you will get feedback");
    }

    private void updateFeedback(String feedback) {
        feedback_txtField.setText(feedback);
    }

    private void updateTrash() {
        Trash[] trash = context.getCurrent().getTrash();
        for (Trash t : trash) {
            if(context.getCurrent() instanceof Genbrugsstation){
                switch (t.getName()) {
                    case "metalskrot":
                        metalskrot_label.setText("Metalskrot: " + t.getAmount());
                        break;
                    case "batterier":
                        batterier_label.setText("Batterier: " + t.getAmount());
                        break;
                    case "plastik":
                        plastik_label.setText("Plastik: " + t.getAmount());
                        break;
                }
            }
        }
    }

    @FXML
    private void recycle(MouseEvent event) {

        Button b = (Button) event.getSource();
        String id = b.getId();
        System.out.println(id);

        int[] moneyXP = null;

        if (id.equals("btn_recycle_1")) {
            System.out.println("We did recycling 1");
             moneyXP = player.recycleBad();
        } else {
            System.out.println("We did recycling 2");
            moneyXP = player.recycleGreen();
        }

        updateFeedback("Du fik: " + moneyXP[0] + " penge og " + moneyXP[1] + " XP");

        System.out.println("You just recycled!");

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
