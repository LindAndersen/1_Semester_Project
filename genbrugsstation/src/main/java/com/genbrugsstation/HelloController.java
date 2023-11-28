package com.genbrugsstation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    Context context = Game.getContext();
    Registry registry = Game.getRegistry();

    @FXML
    private Button Cykelsti;

    @FXML
    private Button Solceller;

    @FXML
    private Button Filter;

    @FXML
    private Button Bus;

    @FXML
    private Button Vinduer;

    @FXML
    private Button Leg;

    @FXML
    private Button Motor;

    @FXML
    private Button Bill;

    @FXML
    private Button Farve;

    @FXML
    private Button Parkering;

    @FXML
    private Button Olie;

    @FXML
    private Button Bold;

    @FXML
    private Label pengetext;

    @FXML
    private Label xptext;

    @FXML
    private Label upgrade1;

    @FXML
    private Label upgrade2;

    @FXML
    private Label upgrade3;

    @FXML
    private Label upgrade4;

    @FXML
    private Label upgrade5;

    @FXML
    private Label upgrade6;

    public void setbuttonopacity(Button a, Button b){
        a.setOpacity(0.5);
        b.setOpacity(0.5);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (pengetext != null & xptext != null) {
            pengetext.setText("Du har " + context.getPlayer().getMoney() + " kr.");
            xptext.setText("Du har " + context.getPlayer().getXP() + " xp.");

            if (upgrade1 != null & upgrade2 != null & upgrade3 != null & upgrade4 != null & upgrade5 != null & upgrade6 != null){
                Butikdata butikdata = Game.getButikdata();

                upgrade1.setText(butikdata.getStringupgrade1());
                switch (butikdata.getStringupgrade1()) {
                    case "":
                        break;

                    case "Cykelsti":
                        setbuttonopacity(Cykelsti,Motor);
                        break;

                }
                upgrade2.setText(butikdata.getStringupgrade2());
                switch (butikdata.getStringupgrade2()) {
                    case "":
                        break;

                    case "Solceller":
                        setbuttonopacity(Solceller,Bill);
                        break;

                }
                upgrade3.setText(butikdata.getStringupgrade3());
                switch (butikdata.getStringupgrade3()) {
                    case "":
                        break;

                    case "Filter i parksøen":
                        setbuttonopacity(Filter,Farve);
                        break;

                }
                upgrade4.setText(butikdata.getStringupgrade4());
                switch (butikdata.getStringupgrade4()) {
                    case "":
                        break;

                    case "Busstoppested":
                        setbuttonopacity(Bus,Parkering);
                        break;

                }
                upgrade5.setText(butikdata.getStringupgrade5());
                switch (butikdata.getStringupgrade5()) {
                    case "":
                        break;

                    case "Isolerende vinduer":
                        setbuttonopacity(Vinduer,Olie);
                        break;

                }
                upgrade6.setText(butikdata.getStringupgrade6());
                switch (butikdata.getStringupgrade6()) {
                    case "":
                        break;

                    case "Legeplads":
                        setbuttonopacity(Leg,Bold);
                        break;

                }
            }
        }

    }

    public void upgradebuttonclick(String a, Button c, Button d){

        int oldmoney = context.getPlayer().getMoney();
        String b = ("buy"+" "+a);
        registry.dispatch(b);
        int newmoney = context.getPlayer().getMoney();
        if (oldmoney != newmoney) {
            setbuttonopacity(c,d);
            pengetext.setText("Du har " + context.getPlayer().getMoney() + " kr.");
            xptext.setText("Du har " + context.getPlayer().getXP() + " xp.");
            switch (a) {
                case "1":
                    Game.getButikdata().setStringupgrade1("Cykelsti");
                    upgrade1.setText(Game.getButikdata().getStringupgrade1());
                    break;

                case "2":
                    Game.getButikdata().setStringupgrade1("Motorvej");
                    upgrade1.setText(Game.getButikdata().getStringupgrade1());
                    break;

                case "3":
                    Game.getButikdata().setStringupgrade2("Billboards");
                    upgrade2.setText(Game.getButikdata().getStringupgrade2());
                    break;

                case "4":
                    Game.getButikdata().setStringupgrade4("Busstoppested");
                    upgrade4.setText(Game.getButikdata().getStringupgrade4());
                    break;

                case "5":
                    Game.getButikdata().setStringupgrade2("Solceller");
                    upgrade2.setText(Game.getButikdata().getStringupgrade2());
                    break;

                case "6":
                    Game.getButikdata().setStringupgrade3("Filter i parksøen");
                    upgrade3.setText(Game.getButikdata().getStringupgrade3());
                    break;

                case "7":
                    Game.getButikdata().setStringupgrade5("Isolerende vinduer");
                    upgrade5.setText(Game.getButikdata().getStringupgrade5());
                    break;

                case "8":
                    Game.getButikdata().setStringupgrade6("Legeplads");
                    upgrade6.setText(Game.getButikdata().getStringupgrade6());
                    break;

                case "9":
                    Game.getButikdata().setStringupgrade3("Farve i parksøen");
                    upgrade3.setText(Game.getButikdata().getStringupgrade3());
                    break;

                case "10":
                    Game.getButikdata().setStringupgrade4("Parkeringshus");
                    upgrade4.setText(Game.getButikdata().getStringupgrade4());
                    break;

                case "11":
                    Game.getButikdata().setStringupgrade5("Oliefyr");
                    upgrade5.setText(Game.getButikdata().getStringupgrade5());
                    break;

                case "12":
                    Game.getButikdata().setStringupgrade6("Fodboldstadion");
                    upgrade6.setText(Game.getButikdata().getStringupgrade6());
                    break;

            }
        }

    }

    @FXML
    private void go(MouseEvent event) throws IOException {
        String id = ((javafx.scene.Node)event.getSource()).getId();
        String location = id.split("_")[1] + "-view";
        System.out.println(location);
        
        Game.setRoot(location);
    }

    @FXML
    protected void onOpgraderingerButtonClick(ActionEvent event) throws IOException  {
        root = FXMLLoader.load(Objects.requireNonNull(Game.class.getResource("Opgraderinger.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        registry.dispatch("go butik");
    }

    @FXML
    protected void onButiktilbageClick(ActionEvent event) throws IOException  {
        root = FXMLLoader.load(Objects.requireNonNull(Game.class.getResource("Butik.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();;
    }

    @FXML
    protected void onCykelstiButtonClick(ActionEvent event) throws IOException  {

        upgradebuttonclick("1",Cykelsti,Motor);

    }

    @FXML
    protected void onSolcellerButtonClick(ActionEvent event) throws IOException  {

        upgradebuttonclick("5",Solceller,Bill);

    }

    @FXML
    protected void onFilterButtonClick(ActionEvent event) throws IOException  {

        upgradebuttonclick("6",Filter,Farve);

    }

    @FXML
    protected void onBusButtonClick(ActionEvent event) throws IOException  {

        upgradebuttonclick("4",Bus,Parkering);

    }

    @FXML
    protected void onVinduerButtonClick(ActionEvent event) throws IOException  {

        upgradebuttonclick("7",Vinduer,Olie);

    }

    @FXML
    protected void onLegButtonClick(ActionEvent event) throws IOException  {

        upgradebuttonclick("8",Leg,Bold);

    }

    @FXML
    protected void onMotorButtonClick(ActionEvent event) throws IOException  {

        upgradebuttonclick("2",Motor,Cykelsti);

    }

    @FXML
    protected void onBillButtonClick(ActionEvent event) throws IOException  {

        upgradebuttonclick("3",Bill,Solceller);

    }

    @FXML
    protected void onFarveButtonClick(ActionEvent event) throws IOException  {

        upgradebuttonclick("9",Farve,Filter);

    }

    @FXML
    protected void onParkeringButtonClick(ActionEvent event) throws IOException  {

        upgradebuttonclick("10",Parkering,Bus);

    }

    @FXML
    protected void onOlieButtonClick(ActionEvent event) throws IOException  {

        upgradebuttonclick("11",Olie,Vinduer);

    }

    @FXML
    protected void onBoldButtonClick(ActionEvent event) throws IOException  {

        upgradebuttonclick("12",Bold,Leg);

    }
}
