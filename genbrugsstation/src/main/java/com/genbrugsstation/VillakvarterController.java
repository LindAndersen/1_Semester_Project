package com.genbrugsstation;

import java.io.IOException;

import javafx.fxml.FXML;
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
    @FXML
    private ImageView Level_bar0, Level_bar1, Level_bar2, Level_bar3, Level_bar4, Level_bar5;

    private AnchorPane[] trashGUIelements;
    private Label[] trashGUIlabels;
    private ImageView[] grass;
    private ImageView[] levelbar;

    @FXML
    public void initialize() {
        grass = new ImageView[] {imageview_grass0, imageview_grass1, imageview_grass2, imageview_grass3, imageview_grass4, imageview_grass5};
        levelbar = new ImageView[]{Level_bar0, Level_bar1, Level_bar2, Level_bar3, Level_bar4, Level_bar5};
        trashGUIelements = new AnchorPane[] {anchorpane_flasker, anchorpane_aviser};
        trashGUIlabels = new Label[] {flasker_label, aviser_label};
        updateFeedback("Here you will get feedback", feedback_txtField);
        updateTrash();
        updateSceneFromUpgrades();
        updateSceneFromLevel();
        makeTrashVisible(trashGUIelements, trashGUIlabels);
    }

    //afgør hvilket græs-lag der skal vises, baseret på spillerens level
    private void updateSceneFromLevel() {
        int lvl = player.getLvl();
        for (int i = 0;i<grass.length;i++) {
            if (lvl == i) {
                grass[i].setOpacity(1);
                levelbar[i].setOpacity(1);
            } else {
                grass[i].setOpacity(0);
                levelbar[i].setOpacity(0);
            }
        }
    }

    //afgør hvordan scenen ser ud, baseret på de købte opgraderinger
    private void updateSceneFromUpgrades() {
        if (isUpgradeBought("Cykelsti")) {
            imageview_cykelsti.setOpacity(1);
        } else if (isUpgradeBought("Motorvej")) {
            imageview_motorvej.setOpacity(1);
        }

        if (isUpgradeBought("Isolerende vinduer")) {
            imageview_isolerendevinduer.setOpacity(1);
        } else if (isUpgradeBought("Varmeanlæg m. oliefyr")) {
            imageview_oliefyr.setOpacity(1);
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
        setRootFromEvent(event);
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
