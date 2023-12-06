package com.genbrugsstation;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;



public class KontorController extends SharedGUIFunc {

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
    }

    @FXML
    private void sleepBtnPressed(){
        updateFeedback("Du lægger dig til at sove og vågner klar til en ny dag", feedback_txtField);
        context.resetDay(world);

    }

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