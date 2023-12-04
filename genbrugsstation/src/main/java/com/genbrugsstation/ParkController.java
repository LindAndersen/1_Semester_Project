package com.genbrugsstation;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ParkController extends SharedGUIFunc {
    @FXML
    private Label aviser_label, flasker_label;
    
    @FXML
    private Text feedback_txtField;
    @FXML
    private ImageView imageview_grass0, imageview_grass1, imageview_grass2, imageview_grass3, imageview_grass4, imageview_grass5;

    @FXML
    private ImageView imageview_filter, imageview_farve, imageview_legeplads, imageview_stadion;

    @FXML
    public void initialize() {
        feedback_txtField.setText("Here you will get feedback");
        updateTrash();
        updateSceneFromUpgrades();
        updateSceneFromLevel();
    }
    private void updateSceneFromLevel() {
        int lvl = player.getLvl();
        ImageView[] grass = new ImageView[] {imageview_grass0, imageview_grass1, imageview_grass2, imageview_grass3, imageview_grass4, imageview_grass5};

        for (int i = 0;i<grass.length;i++) {
            if (lvl == i) {
                grass[i].setOpacity(1);
            } else {
                grass[i].setOpacity(0);
            }
        }
    }

    private void updateSceneFromUpgrades() {
        if (isUpgradeBought("Filter i parksøen")) {
            imageview_filter.setOpacity(1);
        } else if (isUpgradeBought("Farve i parksøen")) {
            imageview_farve.setOpacity(1);
        }

        if (isUpgradeBought("Legeplads")) {
            imageview_legeplads.setOpacity(1);
         } else if (isUpgradeBought("Stadion")) {
             imageview_stadion.setOpacity(1);
        }
    }

    private void updateFeedback(String feedback) {
        feedback_txtField.setText(feedback);
    }

    private void updateTrash() {

        Trash[] trash = context.getCurrent().getTrash();
        for (Trash t : trash) {
            String amountString = Integer.toString(t.getAmount());
            switch (t.getName()) {
                case "aviser":
                    aviser_label.setText(amountString);
                    break;
                case "flasker":
                    flasker_label.setText(amountString);
                    break;
            }
        }
    }


    @FXML
    private void go(MouseEvent event) throws IOException {
        setRootFromEvent(event);
    }

    @FXML
    private void pickup(MouseEvent event) throws TrashNotFoundException {
        String feedback = SharedGUIFunc.pickup(event);
        updateTrash();
        updateFeedback(feedback);
    }

    @FXML
    private void showDefaultMenu() throws IOException {
        setRootFromString("default-menu-view");
    }
}
