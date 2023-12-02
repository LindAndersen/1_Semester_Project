package com.genbrugsstation;

import java.io.IOException;

import javafx.event.Event;
import javafx.scene.control.Button;

public class SharedGUIFunc {
    static Context context = Game.getContext();
    static Player player = context.getPlayer();

    public String getLocationFromEvent(Event event) {
        String id = ((javafx.scene.Node)event.getSource()).getId();
        String location = id.split("_")[1] + "-view";
        return location;
    }

    public void setRootFromEvent(Event event) throws IOException {
        String location = getLocationFromEvent(event);
        Game.setRoot(location);
    }

    public void setRootFromString(String root) throws IOException {
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
}
