package com.genbrugsstation;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Parent;



public class KontorController extends SharedGUIFunc {

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
    private Button goBtn_genbrugsstation, goBtn_butik, goBtn_villakvarter, goBtn_park, goBtn_centrum;
    private Context context;
    private World world;


    public void initialize(){
        context = Game.context;
        world = Game.world;
    }

    @FXML
    protected void sleepBtnPressed(){
        context.resetDay(world);
        System.out.println("du sover nu");

    }

    @FXML
    protected void menuBtnPressed(){
        System.out.println("menu åbner");
        try {
            Game.setRoot("default-menu-view");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void goBtnPressed(ActionEvent e) throws IOException{
        setRootFromEvent(e);
    }

    @FXML
    protected void pcBtnPressed(){
        try {
            Game.setRoot("status-menu-view");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}