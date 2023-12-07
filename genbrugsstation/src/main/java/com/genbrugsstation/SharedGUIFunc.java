package com.genbrugsstation;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SharedGUIFunc {
    static Context context = Game.getContext();
    static Player player = (context != null ? context.getPlayer() : null);

    static Context getContext() {
        return context;
    }

    Player getPlayer() {
        return player;
    }
    //From event getId(), all go buttons that change view have id "go_%location%", so take the location and add "-view", to get name of proper .fxml file
    public String getLocationFromEvent(Event event) {
        String id = ((javafx.scene.Node)event.getSource()).getId();
        String location = id.split("_")[1] + "-view";
        return location;
    }

    public void setRootFromEvent(Event event) throws IOException{
        String location = getLocationFromEvent(event);
        Game.setRoot(location);
    }

    public void setRootFromString(String root) {
        Game.setRoot(root);
    }

    //pickup buttons Id is "pickup_1_%type of trash%", so elm[2] represents type of trash
    //player.pickup returns true if pickup was succesfull and feedback is updated
    static String pickup(Event event) throws TrashNotFoundException {
        String cmd = ((Button)event.getSource()).getId().replace("_", " ");
        String[] elm = cmd.split(" ");

        boolean didPickup = player.pickup(elm[2], 1, context.getCurrent().getTrash());
        return (didPickup ? "Du har samlet 1 " + elm[2] + " op | " + player.getInventory().getItems().get(elm[2]) + " totalt" : "Ikke mere at samle op");
    }

    //Returns a String of amount of present trash in the order its stored in the room (Space)
    public String[] getTrashUpdate() {
        Trash[] trash = context.getCurrent().getTrash();
        String[] update = new String[trash.length];
        for (int i = 0; i<trash.length;i++) {
            update[i] = Integer.toString(trash[i].getAmount());
        }
        return update;
    }

    @FXML
    void showInventory() throws IOException {
        setRootFromString("inventory-view");
    }

    boolean isUpgradeBought(String name) {
        for(String u : Butikdata.getUpgrades()) {
            if (u.equals(name)) {return true;}
        }
        return false;
    }

    //Makes trash label opacity 1 if trashAmount != 0, otherwise opacity=0
    void makeTrashVisible(AnchorPane[] trashGUIelements, Label[] trashGUIlabels) {
        if (trashGUIelements.length != trashGUIlabels.length){
            System.out.println("Not equal amounts of trash and labels");
            return;
        }

        for (int i = 0; i<trashGUIelements.length;i++) {
            trashGUIelements[i].setOpacity((trashGUIlabels[i].getText().equals("0") ? 0 : 1));
        }
    }

    //Makes trash label opacity 1 if trashAmount != 0, otherwise opacity=0
    public void setTrashVisibility(AnchorPane[] trashGUIelements, String[] update) {
        for (int i = 0;i<trashGUIelements.length;i++) {
            if (update[i].equals("0")) {
                trashGUIelements[i].setOpacity(0);
            }
        }
    }

    //updates feedback and here feedback style can be set
    void updateFeedback(String feedback, Text feedback_txtField) {
        feedback_txtField.setText(feedback);
        feedback_txtField.setFill(Color.rgb(84,47,19));
        feedback_txtField.setFont(Font.font("Rockwell", 24));
    }
}
