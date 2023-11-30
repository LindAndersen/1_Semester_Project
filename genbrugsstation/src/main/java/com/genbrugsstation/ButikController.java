package com.genbrugsstation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class ButikController extends SharedGUIFunc {
//    private Stage stage;
//    private Scene scene;
//    private Parent root;

    Context context;

    @FXML
    private Button cykelsti;

    @FXML
    private Button solceller;

    @FXML
    private Button filter;

    @FXML
    private Button bus;

    @FXML
    private Button vinduer;

    @FXML
    private Button leg;

    @FXML
    private Button motor;

    @FXML
    private Button bill;

    @FXML
    private Button farve;

    @FXML
    private Button parkering;

    @FXML
    private Button olie;

    @FXML
    private Button bold;

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



    @FXML
    public void initialize(){
        context = Game.getContext();


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
                        setbuttonopacity(cykelsti,motor);
                        break;

                }
                upgrade2.setText(butikdata.getStringupgrade2());
                switch (butikdata.getStringupgrade2()) {
                    case "":
                        break;

                    case "Solceller":
                        setbuttonopacity(solceller,bill);
                        break;

                }
                upgrade3.setText(butikdata.getStringupgrade3());
                switch (butikdata.getStringupgrade3()) {
                    case "":
                        break;

                    case "Filter i parksøen":
                        setbuttonopacity(filter,farve);
                        break;

                }
                upgrade4.setText(butikdata.getStringupgrade4());
                switch (butikdata.getStringupgrade4()) {
                    case "":
                        break;

                    case "Busstoppested":
                        setbuttonopacity(bus,parkering);
                        break;

                }
                upgrade5.setText(butikdata.getStringupgrade5());
                switch (butikdata.getStringupgrade5()) {
                    case "":
                        break;

                    case "Isolerende vinduer":
                        setbuttonopacity(vinduer,olie);
                        break;

                }
                upgrade6.setText(butikdata.getStringupgrade6());
                switch (butikdata.getStringupgrade6()) {
                    case "":
                        break;

                    case "Legeplads":
                        setbuttonopacity(leg,bold);
                        break;

                }
            }
        }

    }

    public void setbuttonopacity(Button a, Button b){
        a.setOpacity(0.5);
        b.setOpacity(0.5);
    }

    public void upgradeButtonClick(String a, Button c, Button d){
        Player player = context.getPlayer();
        int oldMoney = player.getMoney();
        String b = ("buy "+a);
        Butikdata butikdata = Game.getButikdata();

        player.buy(a, context);

        int newMoney = context.getPlayer().getMoney();
        if (oldMoney != newMoney) {
            setbuttonopacity(c,d);
            pengetext.setText("Du har " + context.getPlayer().getMoney() + " kr.");
            xptext.setText("Du har " + context.getPlayer().getXP() + " xp.");
            switch (a) {
                case "1":
                    butikdata.setStringupgrade1("Cykelsti");
                    upgrade1.setText(butikdata.getStringupgrade1());
                    break;

                case "2":
                    butikdata.setStringupgrade1("Motorvej");
                    upgrade1.setText(butikdata.getStringupgrade1());
                    break;

                case "3":
                    butikdata.setStringupgrade2("Billboards");
                    upgrade2.setText(butikdata.getStringupgrade2());
                    break;

                case "4":
                    butikdata.setStringupgrade4("Busstoppested");
                    upgrade4.setText(butikdata.getStringupgrade4());
                    break;

                case "5":
                    butikdata.setStringupgrade2("Solceller");
                    upgrade2.setText(butikdata.getStringupgrade2());
                    break;

                case "6":
                    butikdata.setStringupgrade3("Filter i parksøen");
                    upgrade3.setText(butikdata.getStringupgrade3());
                    break;

                case "7":
                    butikdata.setStringupgrade5("Isolerende vinduer");
                    upgrade5.setText(butikdata.getStringupgrade5());
                    break;

                case "8":
                    butikdata.setStringupgrade6("Legeplads");
                    upgrade6.setText(butikdata.getStringupgrade6());
                    break;

                case "9":
                    butikdata.setStringupgrade3("Farve i parksøen");
                    upgrade3.setText(butikdata.getStringupgrade3());
                    break;

                case "10":
                    butikdata.setStringupgrade4("Parkeringshus");
                    upgrade4.setText(butikdata.getStringupgrade4());
                    break;

                case "11":
                    butikdata.setStringupgrade5("Oliefyr");
                    upgrade5.setText(butikdata.getStringupgrade5());
                    break;

                case "12":
                    butikdata.setStringupgrade6("Fodboldstadion");
                    upgrade6.setText(butikdata.getStringupgrade6());
                    break;

            }
        }

    }

    @FXML
    private void go(MouseEvent event) throws IOException {
        setRootFromEvent(event);
    }

    @FXML
    protected void onOpgraderingerButtonClick(){
        try{
            Game.setRoot("opgraderinger-view");
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    protected void onButikTilbageClick()  {
        try{
            Game.setRoot("butik-view");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void onCykelstiButtonClick()  {

        upgradeButtonClick("1",cykelsti,motor);

    }

    @FXML
    protected void onSolcellerButtonClick()  {

        upgradeButtonClick("5",solceller,bill);

    }

    @FXML
    protected void onFilterButtonClick()  {

        upgradeButtonClick("6",filter,farve);

    }

    @FXML
    protected void onBusButtonClick()  {

        upgradeButtonClick("4",bus,parkering);

    }

    @FXML
    protected void onVinduerButtonClick(ActionEvent event) throws IOException  {

        upgradeButtonClick("7",vinduer,olie);

    }

    @FXML
    protected void onLegButtonClick(ActionEvent event) throws IOException  {

        upgradeButtonClick("8",leg,bold);

    }

    @FXML
    protected void onMotorButtonClick(ActionEvent event) throws IOException  {

        upgradeButtonClick("2",motor,cykelsti);

    }

    @FXML
    protected void onBillButtonClick(ActionEvent event) throws IOException  {

        upgradeButtonClick("3",bill,solceller);

    }

    @FXML
    protected void onFarveButtonClick(ActionEvent event) throws IOException  {

        upgradeButtonClick("9",farve,filter);

    }

    @FXML
    protected void onParkeringButtonClick(ActionEvent event) throws IOException  {

        upgradeButtonClick("10",parkering,bus);

    }

    @FXML
    protected void onOlieButtonClick(ActionEvent event) throws IOException  {

        upgradeButtonClick("11",olie,vinduer);

    }

    @FXML
    protected void onBoldButtonClick(ActionEvent event) throws IOException  {

        upgradeButtonClick("12",bold,leg);

    }
}
