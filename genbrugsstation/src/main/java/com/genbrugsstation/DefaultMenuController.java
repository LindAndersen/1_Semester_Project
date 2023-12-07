package com.genbrugsstation;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.Window;
import javafx.stage.WindowEvent;


public class DefaultMenuController extends SharedGUIFunc {
    private Stage stage;

    @FXML
    private Button dLeaveBtn, dSaveBtn, dBackBtn, dBackBtn1;

    public void initialize(){
    }

    //lukker spillet
    @FXML
    private void leaveBtnPressed(ActionEvent event){
        try{
            EventHandler<WindowEvent> closeAll = new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    Platform.exit();
                }
            };
            Node n = (Node)event.getSource();
            Scene s = n.getScene();//fetches the scene from at the source
            stage = (Stage)s.getWindow();

            Window w = s.getWindow();
            w.setOnHidden(closeAll);
            stage.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void saveGame() {
        Game.save_game(context);
    }
    @FXML
    private void backBtn(){
        try {
            Game.setRoot(Game.prevView);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
