package com.genbrugsstation;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.stage.Window;
import javafx.stage.WindowEvent;


public class MainMenuController extends SharedGUIFunc {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Context context;

//    @FXML
//    private ImageView menuImageView;
//    private Image menuPic = new Image("/menu.png");
    @FXML
    private Button newGameBtn, leaveBtn, loadBtn, btn_savegame;


    public void initialize(){
        context = Game.context;
    }

    @FXML
    protected void newGameBtnPressed() throws IOException{
        Game.newGame();
        setRootFromString("kontor-view");
    }

    @FXML
    protected void leaveBtnPressed(ActionEvent event){
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
        Game.save_game();
    }

    @FXML
    private void loadGame() throws ClassNotFoundException, IOException {
        Game.load_game();
    }

}