package com.genbrugsstation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;
import java.util.Map;


public class StatusMenuController {

    @FXML
    private Label xpLabel;
    @FXML
    private Label plastikNumber;
    @FXML
    private Label flaskeNumber;
    @FXML
    private Label batteriNumber;
    @FXML
    private Label avisNumber;
    @FXML
    private Label metalNumber;

    @FXML
    private Label coinLabel;

    @FXML
    private Label lvlLabel;

    @FXML
    private Label dayLabel;

    private Stage stage;
    @FXML
    private ImageView statusMenuImageView;

    @FXML
    private Button backBtn;

    private Context context = Game.context;
    private Player player;

    @FXML
    public void initialize(){
        player = context.getPlayer();
        updateLabels();
    }

    private void updateLabels(){
        Map<String, Integer> items = player.getInventory().getItems();
        System.out.println(items);
        xpLabel.setText(Integer.toString(player.getXP()));
        coinLabel.setText(Integer.toString(player.getMoney()));
        lvlLabel.setText(Integer.toString(player.getLvl())+ player.remainingXP() + "/100");
        dayLabel.setText(Integer.toString(context.getDay()));

//        if(!(items.isEmpty())) {
            flaskeNumber.setText(items.get("flasker").toString());
            batteriNumber.setText(items.get("batterier").toString());
            metalNumber.setText(items.get("metalskrot").toString());
            plastikNumber.setText(items.get("plastik").toString());
            avisNumber.setText(items.get("aviser").toString());
//        }
    }

    @FXML
    protected void backBtnPressed(ActionEvent event){
        try {
            Game.setRoot("kontor-view");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
