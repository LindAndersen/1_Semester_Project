package com.genbrugsstation;

import java.io.IOException;

import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class SharedGUIFunc {
    static Context context = Game.getContext();
    static Player player = Game.context.getPlayer();

    public String getLocationFromEvent(Event event) {
        String id = ((javafx.scene.Node)event.getSource()).getId();
        String location = id.split("_")[1] + "-view";
        return location;
    }

    public void setRootFromEvent(Event event) {
        String location = getLocationFromEvent(event);
        Game.setRoot(location);
    }

    public void setRootFromString(String root) {
        Game.setRoot(root);
    }

    public static String pickup(Event event) throws TrashNotFoundException {
        String cmd = ((Button)event.getSource()).getId().replace("_", " ");
        String[] elm = cmd.split(" ");

        boolean didPickup = player.pickup(elm[2], 1, context.getCurrent().getTrash());
        return (didPickup ? "Du har samlet 1 " + elm[2] + " op | " + player.getInventory().getItems().get(elm[2]) + " totalt" : "Ikke mere at samle op");
    }

    public String[] getTrashUpdate() {
        Trash[] trash = context.getCurrent().getTrash();
        String[] update = new String[trash.length];
        for (int i = 0; i<trash.length;i++) {
            update[i] = Integer.toString(trash[i].getAmount());
        }

        return update;
    }

    public void showInventory() throws IOException {
        setRootFromString("inventory-view");
    }

    public boolean isUpgradeBought(String name) {
        for(String u : Butikdata.getUpgrades()) {
            if (u.equals(name)) {return true;}
        }

        return false;
    }

    public void makeTrashVisible(AnchorPane[] trashGUIelements, Label[] trashGUIlabels) {
        if (trashGUIelements.length != trashGUIlabels.length){
            System.out.println("Not equal amounts of trash and labels");
            return;
        }

        for (int i = 0; i<trashGUIelements.length;i++) {
            trashGUIelements[i].setOpacity((trashGUIlabels[i].getText().equals("0") ? 0 : 1));
        }
    }

    public void setTrashVisibility(AnchorPane[] trashGUIelements, String[] update) {
        for (int i = 0;i<trashGUIelements.length;i++) {
            if (update[i].equals("0")) {
                trashGUIelements[i].setOpacity(0);
            }
        }
    }

    public void updateFeedback(String feedback, Text feedback_txtField) {
        feedback_txtField.setText(feedback);
        feedback_txtField.setStyle("-fx-text-fill: green;");
    }
}
