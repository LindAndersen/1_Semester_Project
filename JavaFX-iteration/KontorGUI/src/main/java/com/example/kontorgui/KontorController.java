package com.example.kontorgui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Parent;



public class KontorController {

    @FXML
    private ImageView kontorImageView;
    private Image kontorPic = new Image("/kontorpic.png");

    @FXML
    private Button sleepBtn;

    @FXML
    private ImageView gearMenuImageView;
    private Image gearMenuPic = new Image("/tandhjul.png");

    @FXML
    private Button gearMenuBtn;

    @FXML
    private Button pcBtn;

    @FXML
    private Button goBtn;

    private CommandStatus cmdStatus;
    private CommandGo cmdGo;
//    private CommandHelp cmdHelp;
    private CommandResetDay cmdReset;
    private Context context;
    private World world;


    public void initialize(){
        kontorImageView.setImage(kontorPic);

        gearMenuImageView.setImage(gearMenuPic);

        context = MainApplication.context;
        world = MainApplication.world;
    }

    @FXML
    protected void sleepBtnPressed(){
        cmdReset = new CommandResetDay(world);
        cmdReset.execute(context, "reset");
        System.out.println("du sover nu");

    }

    @FXML
    protected void menuBtnPressed(){
        System.out.println("menu åbner");
        try {
            FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("menu-view.fxml")) ;
            Parent anotherRoot = anotherLoader.load();
            Scene anotherScene = new Scene(anotherRoot);
            Stage anotherStage = new Stage();
            anotherStage.setScene(anotherScene);
            anotherStage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void goBtnPressed(){
        cmdGo = new CommandGo();
        cmdGo.execute(context, goBtn.getText());
    }

    @FXML
    protected void pcBtnPressed(){
        cmdStatus = new CommandStatus();
        cmdStatus.execute(context, "status");

        try {
            FXMLLoader statusMenuLoader = new FXMLLoader(getClass().getResource("status-menu-view.fxml")) ;
            Parent statusMenuRoot = statusMenuLoader.load();
            Scene statusMenuScene = new Scene(statusMenuRoot);
            Stage statusMenuStage = new Stage();

            statusMenuStage.setScene(statusMenuScene);
            statusMenuStage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}