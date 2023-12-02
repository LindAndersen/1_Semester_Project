package com.genbrugsstation;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class VillakvarterController extends SharedGUIFunc {    
    @FXML
    private Label aviser_label;
    @FXML
    private Label flasker_label;
    @FXML
    private Text feedback_txtField;

    @FXML
    private ImageView imageview_cykelsti, imageview_isolerendevinduer, imageview_motorvej, imageview_oliefyr;

    @FXML
    public void initialize() {
        feedback_txtField.setText("Here you will get feedback");
        updateTrash();
        updateSceneFromUpgrades();
    }

    private void updateSceneFromUpgrades() {
        if (isUpgradeBought("Cykelsti")) {
            imageview_cykelsti.setOpacity(1);
        } else if (isUpgradeBought("Motorvej")) {
            imageview_motorvej.setOpacity(1);
        }

        if (isUpgradeBought("Isolerende vinduer")) {
            imageview_isolerendevinduer.setOpacity(1);
        } else if (isUpgradeBought("Oliefyr")) {
            imageview_oliefyr.setOpacity(1);
        }
    }

    private void updateFeedback(String feedback) {
        feedback_txtField.setText(feedback);
    }

    private void updateTrash() {
        String[] update = getTrashUpdate();
        flasker_label.setText(update[0]);
        aviser_label.setText(update[1]);
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
