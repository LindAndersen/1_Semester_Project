package com.genbrugsstation;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class GenbrugsstationController extends SharedGUIFunc {
    private Context context;
    private Player player;

    @FXML
    private Label metalskrot_label, batterier_label, plastik_label;
    @FXML
    private Text feedback_txtField;
    @FXML
    private ImageView go_back;

    @FXML
    public void initialize() {
        context = Game.getContext();
        player = context.getPlayer();
        updateTrash();
        updateFeedback("Here you will get feedback");
    }

    private void updateFeedback(String feedback) {
        feedback_txtField.setText(feedback);
    }

    private void updateTrash() {
        if (metalskrot_label == null) {return;}
        Trash[] trash = context.getCurrent().getTrash();
        for (Trash t : trash) {
            String amount = Integer.toString(t.getAmount());
            switch (t.getName()) {
                case "metalskrot":
                    metalskrot_label.setText(amount);
                    break;
                case "batterier":
                    batterier_label.setText(amount);
                    break;
                case "plastik":
                    plastik_label.setText(amount);
                    break;
            }
        }
    }

    @FXML
    private void goRecycleWindow(MouseEvent event) throws IOException {
        setRootFromString("genbrugsstationRecycle-view");
    }

    @FXML
    private void recycle(MouseEvent event) {

        Button b = (Button) event.getSource();
        String id = b.getId();

        int[] moneyXP = null;

        if (id.equals("btn_recycle_1")) {
             moneyXP = player.recycleBad();
        } else {
            moneyXP = player.recycleGreen();
        }

        updateFeedback("Du fik: " + moneyXP[0] + " penge og " + moneyXP[1] + " XP");
        moneyXP = null;


    }

    @FXML
    private void go(MouseEvent event) throws IOException {
        setRootFromEvent(event);
    }

    @FXML
    private void pickup(MouseEvent event) throws TrashNotFoundException {
        String feedback = SharedGUIFunc.pickup(event);
        updateTrash();
        updateFeedback(feedback);
    }

    @FXML
    private void goGenbrugsstationView() throws IOException {
        setRootFromString("genbrugsstation-view");
    }

    @FXML
    private void showDefaultMenu() throws IOException {
        setRootFromString("default-menu-view");
    }
}
