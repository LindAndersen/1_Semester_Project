package com.genbrugsstation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.util.Map;


public class StatusMenuController extends SharedGUIFunc {

    //statusmenuen giver overblik over xp, level, mønter, dag og inventar

    @FXML
    private Label plastikNumber, flaskeNumber, batteriNumber, avisNumber, metalNumber;
    @FXML
    private Label coinLabel, lvlLabel, dayLabel, xpLabel;
    @FXML
    private ImageView statusMenuImageView;
    @FXML
    private Button backBtn;

    @FXML
    public void initialize(){
        updateLabels();
    }

    private void updateLabels(){
        Map<String, Integer> items = Game.getContext().getPlayer().getInventory().getItems();
        Player player = Game.getContext().getPlayer();
        xpLabel.setText(Integer.toString(player.getXP()));
        coinLabel.setText(Integer.toString(player.getMoney()));
        lvlLabel.setText(Integer.toString(player.getLvl()));
        dayLabel.setText(Integer.toString(context.getDay()));

        flaskeNumber.setText(items.get("flasker").toString());
        batteriNumber.setText(items.get("batterier").toString());
        metalNumber.setText(items.get("metalskrot").toString());
        plastikNumber.setText(items.get("plastik").toString());
        avisNumber.setText(items.get("aviser").toString());
    }

    @FXML
    private void backBtnPressed(ActionEvent event) throws IOException{
        setRootFromString("kontor-view");
    }
}
