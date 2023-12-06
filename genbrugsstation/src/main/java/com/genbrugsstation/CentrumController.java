package com.genbrugsstation;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class CentrumController extends SharedGUIFunc {
    @FXML
    private Label aviser_label;
    @FXML
    private Label flasker_label;
    @FXML
    private Text feedback_txtField;
    @FXML
    private ImageView imageview_billboard, imageview_busstoppested, imageview_parkeringshus, imageview_solceller;
    @FXML
    private AnchorPane anchorpane_flasker, anchorpane_aviser;
    @FXML
    private ImageView Level_bar0, Level_bar1, Level_bar2, Level_bar3, Level_bar4, Level_bar5;

    private AnchorPane[] trashGUIelements;
    private Label[] trashGUIlabels;
    private ImageView[] levelbar;
    @FXML
    private Text HintDisplay;


    // trashGUIelements -> contains all anchorpanes, which contains all elements (imageview, button, label) of trash
    // trashGUIlabels -> the label for all trash is very the amount is present
    // SharedGUIFunc.updateFeedBack() takes the feedback String and the Text element to update
    // updateSceneFromUpgrades() handles the opacity of upgrade views to make sure bought upgrades are visible
    // updateTrash() updates the Text field of via trashGUIelements
    // makeTrashVisible() makes trash visible again upon reentry into the Space
    @FXML
    public void initialize() {
        levelbar = new ImageView[]{Level_bar0, Level_bar1, Level_bar2, Level_bar3, Level_bar4, Level_bar5};
        trashGUIelements = new AnchorPane[] {anchorpane_flasker, anchorpane_aviser};
        trashGUIlabels = new Label[] {flasker_label, aviser_label};
        updateFeedback("Here you will get feedback", feedback_txtField);
        updateSceneFromUpgrades();
        updateSceneFromLevel();
        updateTrash();
        makeTrashVisible(trashGUIelements, trashGUIlabels);
        updateWelcomeFromDay();
    }

    //afgør hvilken level-bar der skal vises, baseret på spillerens level
    private void updateSceneFromLevel() {
        int lvl = player.getLvl();
        for (int i = 0;i<levelbar.length;i++) {
            if (lvl == i) {
                levelbar[i].setOpacity(1);
            } else {
                levelbar[i].setOpacity(0);
            }
        }
    }
    //Giver hints på dag 1
    private void updateWelcomeFromDay() {
        int day = context.getDay();
            if (day == 1) {
                HintDisplay.setOpacity(1);

            } else {
                HintDisplay.setOpacity(0);

            }
    }
    // updateSceneFromUpgrades() handles the opacity of upgrade views to make sure bought upgrades are visible
    private void updateSceneFromUpgrades() {
        if (isUpgradeBought("Billboards")) {
            imageview_billboard.setOpacity(1);
        } else if (isUpgradeBought("Solceller")) {
            imageview_solceller.setOpacity(1);
        }

        if (isUpgradeBought("Busstoppested")) {
            imageview_busstoppested.setOpacity(1);
        } else if (isUpgradeBought("Parkeringshus")) {
            imageview_parkeringshus.setOpacity(1);
        }
    }

    private void updateTrash() {
        String[] update = getTrashUpdate();
        setTrashVisibility(trashGUIelements, update);
        flasker_label.setText(update[0]);
        aviser_label.setText(update[1]);
    }

    @FXML
    private void go(MouseEvent event) throws IOException {
        String location = getLocationFromEvent(event);
        Game.setRoot(location);
    }

    @FXML
    private void pickup(MouseEvent event) throws TrashNotFoundException {
        String feedback = SharedGUIFunc.pickup(event);
        updateTrash();
        updateFeedback(feedback, feedback_txtField);
    }

    @FXML
    private void showDefaultMenu() throws IOException {
        setRootFromString("default-menu-view");
    }
}
