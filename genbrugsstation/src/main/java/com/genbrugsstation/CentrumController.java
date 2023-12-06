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

    private AnchorPane[] trashGUIelements;
    private Label[] trashGUIlabels;

    // trashGUIelements -> contains all anchorpanes, which contains all elements (imageview, button, label) of trash
    // trashGUIlabels -> the label for all trash is very the amount is present
    // SharedGUIFunc.updateFeedBack() takes the feedback String and the Text element to update
    // updateSceneFromUpgrades() handles the opacity of upgrade views to make sure bought upgrades are visible
    // updateTrash() updates the Text field of via trashGUIelements
    // makeTrashVisible() makes trash visible again upon reentry into the Space
    @FXML
    public void initialize() {
        trashGUIelements = new AnchorPane[] {anchorpane_flasker, anchorpane_aviser};
        trashGUIlabels = new Label[] {flasker_label, aviser_label};
        updateFeedback("Here you will get feedback", feedback_txtField);
        updateSceneFromUpgrades();
        updateTrash();
        makeTrashVisible(trashGUIelements, trashGUIlabels);
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
        setRoot(location);
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
