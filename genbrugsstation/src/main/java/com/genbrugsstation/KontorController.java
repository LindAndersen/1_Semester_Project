package com.genbrugsstation;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;



public class KontorController extends SharedGUIFunc {
    @FXML
    private ImageView HintDisplayKontor;

    @FXML
    private ImageView kontorImageView, gearMenuImageView;

    @FXML
    private Button gearMenuBtn, pcBtn, sleepBtn;
    @FXML
    private Button goBtn_genbrugsstation, goBtn_butik, goBtn_villakvarter, goBtn_park, goBtn_centrum;
    @FXML
    private Text feedback_txtField;

    private static World world;

    public void initialize(){
        world = Game.world;
        updateWelcomeFromDay();
    }

    @FXML
    //Giver hints på dag 1
    private void updateWelcomeFromDay() {
        int day = context.getDay();
        if (day == 1) {
            HintDisplayKontor.setOpacity(1);
        } else {
            HintDisplayKontor.setOpacity(0);
        }
    }
    @FXML
    private void sleepBtnPressed(){
        context.resetDay(world);
        updateFeedback(String.format("Du lægger dig til at sove og vågner klar til dag nr. %d", context.getDay()), feedback_txtField);

    }
    //Giver hints på dag 1

    @FXML
    private void menuBtnPressed() {
        Game.setRoot("default-menu-view");
    }


    @FXML
    private void goBtnPressed(ActionEvent e) throws IOException {
        setRootFromEvent(e);
    }

    //åbner en statusmenu med oversigt over xp, level, penge og inventar
    @FXML
    private void pcBtnPressed() {
        Game.setRoot("status-menu-view");
    }

}