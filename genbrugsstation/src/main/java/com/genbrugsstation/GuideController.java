package com.genbrugsstation;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GuideController extends SharedGUIFunc {
    private Stage stage;

    @FXML
    private Button gearmenubtn;

    @FXML
    private ImageView GuideMenu;

    public void initialize (){

    }

    @FXML
    private void menubtnpressed(){
        Game.setRoot("main-menu-view");
    }


}
