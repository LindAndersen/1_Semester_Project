package com.genbrugsstation;

import java.io.IOException;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class InventoryController extends SharedGUIFunc {
    @FXML
    private Text text_plastik, text_flasker, text_batterier, text_aviser, text_metalskrot;

    public void initialize() {
        Map<String, Integer> items = player.getInventory().getItems();
        for (String t : items.keySet()) {
            String trashAmount = Integer.toString(items.get(t));
            switch (t) {
                case "plastik" :
                    text_plastik.setText(trashAmount);
                    break;
                case "flasker" :
                    text_flasker.setText(trashAmount);
                    break;
                case "batterier" :
                    text_batterier.setText(trashAmount);
                    break;
                case "aviser" :
                    text_aviser.setText(trashAmount);
                    break;
                case "metalskrot" :
                    text_metalskrot.setText(trashAmount);
                    break;
            }
        }
    }

    @FXML
    private void go_back() throws IOException {
        setRootFromString(Game.prevView);
    }
}
