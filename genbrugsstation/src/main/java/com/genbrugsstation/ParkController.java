package com.genbrugsstation;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ParkController extends SharedGUIFunc {
    private Context context = Game.getContext();

    @FXML
    private Label aviser_label;
    @FXML
    private Label flasker_label;
    @FXML
    private Text feedback_txtField;

    @FXML
    public void initialize() {
        player = context.getPlayer();
        feedback_txtField.setText("Here you will get feedback");
        updateTrash();
    }

    private void updateFeedback(String feedback) {
        feedback_txtField.setText(feedback);
    }

    private void updateTrash() {

        Trash[] trash = context.getCurrent().getTrash();
        for (Trash t : trash) {
            switch (t.getName()) {
                case "aviser":
                    aviser_label.setText("aviser: " + t.getAmount());
                    break;
                case "flasker":
                    flasker_label.setText("flasker: " + t.getAmount());
                    break;
            }
        }
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
    private void showDefaultMenu() throws IOException {
        setRootFromString("default-menu-view");
    }
}
