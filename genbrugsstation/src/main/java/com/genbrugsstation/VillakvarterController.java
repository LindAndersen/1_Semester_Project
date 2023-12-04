package com.genbrugsstation;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class VillakvarterController extends SharedGUIFunc {    
    @FXML
    private Label aviser_label;
    @FXML
    private Label flasker_label;
    @FXML
    private Text feedback_txtField;

    @FXML
    private ImageView imageview_grass0, imageview_grass1, imageview_grass2, imageview_grass3, imageview_grass4, imageview_grass5;
    @FXML
    private AnchorPane anchorpane_aviser, anchorpane_flasker;
    @FXML
    private ImageView imageview_cykelsti, imageview_isolerendevinduer, imageview_motorvej, imageview_oliefyr;

    private AnchorPane[] trashGUIelements;
    private Label[] trashGUIlabels;

    @FXML
    public void initialize() {
        trashGUIelements = new AnchorPane[] {anchorpane_flasker, anchorpane_aviser};
        trashGUIlabels = new Label[] {flasker_label, aviser_label};
        feedback_txtField.setText("Here you will get feedback");
        updateTrash();
        updateSceneFromUpgrades();
        updateSceneFromLevel();
        makeTrashVisible(trashGUIelements, trashGUIlabels);
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
        setTrashVisibility(trashGUIelements, update);
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
