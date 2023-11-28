package com.genbrugsstation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.util.Map;


public class StatusMenuController {

    @FXML
    private Label xpLabel;

    @FXML
    private Label coinLabel;

    @FXML
    private Label lvlLabel;

    @FXML
    private Label dayLabel;

    @FXML
    private Label invLabel;
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
        xpLabel.setText(Integer.toString(player.getXP()));
        coinLabel.setText(Integer.toString(player.getMoney()));
        lvlLabel.setText(Integer.toString(player.getLvl())+ player.remainingXP() + "/100");
        dayLabel.setText(Integer.toString(context.getDay()));
        invLabel.setText(items.toString());
    }

    @FXML
    protected void backBtnPressed(ActionEvent event){
        Node n = (Node)event.getSource();
        Scene s = n.getScene();
        stage = (Stage)s.getWindow();
        stage.close();
    }
}
