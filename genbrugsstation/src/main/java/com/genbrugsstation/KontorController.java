package com.genbrugsstation;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;



public class KontorController extends SharedGUIFunc {

    @FXML
    private ImageView kontorImageView;
    @FXML
    private ImageView gearMenuImageView;

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
    protected void sleepBtnPressed(){
        updateFeedback("Du ligger dig til at sove, men vågner fordi du kan høre folk smide med skrald", feedback_txtField);
        context.resetDay(world);
        //System.out.println("du sover nu");

    }

    @FXML
    protected void menuBtnPressed() {
        System.out.println("menu åbner");
        Game.setRoot("default-menu-view");
    }


    @FXML
    protected void goBtnPressed(ActionEvent e) {
        setRootFromEvent(e);
    }

    @FXML
    protected void pcBtnPressed() {
        Game.setRoot("status-menu-view");
    }

}