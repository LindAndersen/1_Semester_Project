package com.genbrugsstation;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GuideController extends SharedGUIFunc {
    private Stage stage;

    private Button klikher, gearmenubtn;

    public void initialize (){

    }

    @FXML
    private void menubtnpressed(){
        Game.setRoot("default-menu-view");
    }


}
