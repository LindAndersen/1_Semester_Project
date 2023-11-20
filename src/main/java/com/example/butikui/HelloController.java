package com.example.butikui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    protected void onOpgraderingerButtonClick(ActionEvent event) throws IOException  {
        root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("Opgraderinger.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();;
    }

    @FXML
    protected void onButiktilbageClick(ActionEvent event) throws IOException  {
        root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("Butik.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();;
    }

    @FXML
    protected void onCykelstiButtonClick(ActionEvent event) throws IOException  {

    }

    @FXML
    protected void onSolcellerButtonClick(ActionEvent event) throws IOException  {

    }

    @FXML
    protected void onFilterButtonClick(ActionEvent event) throws IOException  {

    }

    @FXML
    protected void onBusButtonClick(ActionEvent event) throws IOException  {

    }

    @FXML
    protected void onVinduerButtonClick(ActionEvent event) throws IOException  {

    }

    @FXML
    protected void onLegButtonClick(ActionEvent event) throws IOException  {

    }

    @FXML
    protected void onMotorButtonClick(ActionEvent event) throws IOException  {

    }

    @FXML
    protected void onBillButtonClick(ActionEvent event) throws IOException  {

    }

    @FXML
    protected void onFarveButtonClick(ActionEvent event) throws IOException  {

    }

    @FXML
    protected void onParkeringButtonClick(ActionEvent event) throws IOException  {

    }

    @FXML
    protected void onOlieButtonClick(ActionEvent event) throws IOException  {

    }

    @FXML
    protected void onBoldButtonClick(ActionEvent event) throws IOException  {

    }
}