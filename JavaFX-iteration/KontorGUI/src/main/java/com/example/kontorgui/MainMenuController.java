package com.example.kontorgui;

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


public class MainMenuController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Context context;

    @FXML
    private ImageView menuImageView;
    private Image menuPic = new Image("/menu.png");
    @FXML
    private Button newGameBtn;
    @FXML
    private Button leaveBtn;

    public void initialize(){
        menuImageView.setImage(menuPic);
        context = MainApplication.context;
    }

    @FXML
    protected void newGameBtnPressed(ActionEvent event){
        System.out.println("nyt spil");
        try{
            root = FXMLLoader.load(getClass().getResource("kontor-view.fxml"));
            Node n = (Node)event.getSource();//fetches source of event and saves as Node-object
            Scene s = n.getScene();//fetches the scene from at the source
            stage = (Stage)s.getWindow();//fetches the window that contains the scene and saves as Stage-object
            scene = new Scene(root);//updates the scene
            stage.setScene(scene);//sets the stage with updated scene
            stage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    @FXML
    protected void leaveBtnPressed(ActionEvent event){
        System.out.println("forlad spil");
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
            if(!context.isDone()){
                context.makeDone();
            }
            Window w = s.getWindow();
            w.setOnHidden(closeAll);
            stage.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
