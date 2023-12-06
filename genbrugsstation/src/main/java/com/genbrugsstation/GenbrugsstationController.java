package com.genbrugsstation;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class GenbrugsstationController extends SharedGUIFunc {

    @FXML
    public ImageView HintDisplayGenbrug;
    @FXML
    private Label metalskrot_label, batterier_label, plastik_label;
    @FXML
    private AnchorPane anchorpane_plastik, anchorpane_metalskrot, anchorpane_batterier;
    @FXML
    private Text feedback_txtField;
    @FXML
    private ImageView go_back;
    @FXML
    private ImageView imageview_græslvl0, imageview_græslvl1, imageview_græslvl2, imageview_græslvl3, imageview_græslvl4, imageview_græslvl5;
    @FXML
    private ImageView Level_bar0,Level_bar1, Level_bar2, Level_bar3, Level_bar4, Level_bar5;

    private AnchorPane[] trashGUIelements;
    private Label[] trashGUIlabels;

    private ImageView[] grass;
    private ImageView[] levelbar;



    //This controller is used by both genbrugsstation-view and genbrugsstationRecycle-view
    //For this reason checks are implemented in initialize() to check if grass and trash exists, if they do update them
    //Feedback Text object is present in both .fxml files, so we can update without checks

    @FXML
    public void initialize() {
        grass = new ImageView[] {imageview_græslvl0, imageview_græslvl1, imageview_græslvl2, imageview_græslvl3, imageview_græslvl4, imageview_græslvl5};
        levelbar = new ImageView[] {Level_bar0,Level_bar1, Level_bar2, Level_bar3, Level_bar4, Level_bar5};


        trashGUIelements  = new AnchorPane[]{anchorpane_metalskrot, anchorpane_batterier, anchorpane_plastik};
        trashGUIlabels = new Label[] {metalskrot_label, batterier_label, plastik_label};
        if (!(imageview_græslvl1 == null)) {updateSceneFromLevel();}
        if (!(metalskrot_label == null)) {updateTrash();makeTrashVisible(trashGUIelements, trashGUIlabels);}
        updateFeedback("Here you will get feedback", feedback_txtField);
        updateWelcomeFromDay();



    }

    //Loops over all grass ImageViews to set only one of them corresponding with lvl to opacity=1, rest will be set to opacity=0
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
    private void updateWelcomeFromDay() {
        int day = context.getDay();
        if (day == 1) {
            HintDisplayGenbrug.setOpacity(1);
        } else {
            HintDisplayGenbrug.setOpacity(0);
        }
    }
    private void updateTrash() {
        String[] update = getTrashUpdate();
        setTrashVisibility(trashGUIelements, update);
        metalskrot_label.setText(update[0]);
        batterier_label.setText(update[1]);
        plastik_label.setText(update[2]);
    }

    @FXML
    private void goRecycleWindow(MouseEvent event) throws IOException {
        setRootFromString("genbrugsstationRecycle-view");
    }

    @FXML
    private void recycle(MouseEvent event) {

        Button b = (Button) event.getSource();
        String id = b.getId();

        int[] moneyXP = null;

        if (id.equals("btn_recycle_1")) {
             moneyXP = player.recycleBad();
        } else {
            moneyXP = player.recycleGreen();
        }

        updateFeedback("Du fik: " + moneyXP[0] + " penge og " + moneyXP[1] + " XP", feedback_txtField);
        moneyXP = null;


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
    private void goGenbrugsstationView() throws IOException {
        setRootFromString("genbrugsstation-view");
    }

    @FXML
    private void showDefaultMenu() throws IOException {
        setRootFromString("default-menu-view");
    }
}
