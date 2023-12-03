package com.genbrugsstation;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.Window;
import javafx.stage.WindowEvent;


public class GameOverController extends SharedGUIFunc {

    private Stage stage;

    @FXML
    private Button startNewGameBtn, leaveSaveBtn, backToGameBtn;
    @FXML
    private TextField text;

    public void initialize(){
        setTextField();
    }

    private void setTextField(){
        Player player = context.getPlayer();
        switch (player.getLvl()){
            case 1:
                text.setText("du sluttede på level 1");
                break;
            case 2:
                text.setText("du sluttede på level 2");
                break;
            case 3:
                text.setText("du sluttede på level 3");
                break;
            case 4:
                text.setText("du sluttede på level 4");
                break;
            case 5:
                text.setText("du sluttede på level 5");
                break;
        }
    }

    @FXML
    protected void backToGamePressed(){
        try {
            setRootFromString("opgraderinger-view");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    @FXML
    protected void newGamePressed() throws IOException{
        Game.newGame();
        setRootFromString("kontor-view");
    }

    @FXML
    protected void leaveSavePressed(ActionEvent event){
        Game.save_game();
        try{
            EventHandler<WindowEvent> closeAll = new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    Platform.exit();
                }
            };

            Node n = (Node)event.getSource();
            Scene s = n.getScene();
            stage = (Stage)s.getWindow();

            Window w = s.getWindow();
            w.setOnHidden(closeAll);
            stage.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
