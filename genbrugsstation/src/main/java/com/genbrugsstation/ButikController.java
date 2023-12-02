package com.genbrugsstation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class ButikController extends SharedGUIFunc {
//    private Stage stage;
//    private Scene scene;
//    private Parent root;

    @FXML
    private Button cykelsti, solceller, filter, bus, vinduer, leg, motor, bill, farve, parkering, olie, bold;

    @FXML
    private Label pengetext, xptext, upgrade1, upgrade2, upgrade3, upgrade4, upgrade5, upgrade6;

    @FXML
    public void initialize(){

        if (pengetext != null & xptext != null) {
            pengetext.setText("Du har " + context.getPlayer().getMoney() + " kr.");
            xptext.setText("Du har " + context.getPlayer().getXP() + " xp.");

            if (upgrade1 != null & upgrade2 != null & upgrade3 != null & upgrade4 != null & upgrade5 != null & upgrade6 != null){

                upgrade1.setText(Butikdata.getStringupgrade1());
                switch (Butikdata.getStringupgrade1()) {
                    case "":
                        break;

                    case "Cykelsti":
                        setbuttonopacity(cykelsti,motor);
                        break;

                }
                upgrade2.setText(Butikdata.getStringupgrade2());
                switch (Butikdata.getStringupgrade2()) {
                    case "":
                        break;

                    case "Solceller":
                        setbuttonopacity(solceller,bill);
                        break;

                }
                upgrade3.setText(Butikdata.getStringupgrade3());
                switch (Butikdata.getStringupgrade3()) {
                    case "":
                        break;

                    case "Filter i parksøen":
                        setbuttonopacity(filter,farve);
                        break;

                }
                upgrade4.setText(Butikdata.getStringupgrade4());
                switch (Butikdata.getStringupgrade4()) {
                    case "":
                        break;

                    case "Busstoppested":
                        setbuttonopacity(bus,parkering);
                        break;

                }
                upgrade5.setText(Butikdata.getStringupgrade5());
                switch (Butikdata.getStringupgrade5()) {
                    case "":
                        break;

                    case "Isolerende vinduer":
                        setbuttonopacity(vinduer,olie);
                        break;

                }
                upgrade6.setText(Butikdata.getStringupgrade6());
                switch (Butikdata.getStringupgrade6()) {
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
        int oldMoney = player.getMoney();

        player.buy(a, context);

        int newMoney = context.getPlayer().getMoney();
        if (oldMoney != newMoney) {
            setbuttonopacity(c,d);
            pengetext.setText("Du har " + context.getPlayer().getMoney() + " kr.");
            xptext.setText("Du har " + context.getPlayer().getXP() + " xp.");
            switch (a) {
                case "1":
                    Butikdata.setStringupgrade1("Cykelsti");
                    upgrade1.setText(Butikdata.getStringupgrade1());
                    break;

                case "2":
                    Butikdata.setStringupgrade1("Motorvej");
                    upgrade1.setText(Butikdata.getStringupgrade1());
                    break;

                case "3":
                    Butikdata.setStringupgrade2("Billboards");
                    System.out.println("Sætter string upgrade til billboard");
                    upgrade2.setText(Butikdata.getStringupgrade2());
                    break;

                case "4":
                    Butikdata.setStringupgrade4("Busstoppested");
                    upgrade4.setText(Butikdata.getStringupgrade4());
                    break;

                case "5":
                    Butikdata.setStringupgrade2("Solceller");
                    upgrade2.setText(Butikdata.getStringupgrade2());
                    break;

                case "6":
                    Butikdata.setStringupgrade3("Filter i parksøen");
                    upgrade3.setText(Butikdata.getStringupgrade3());
                    break;

                case "7":
                    Butikdata.setStringupgrade5("Isolerende vinduer");
                    upgrade5.setText(Butikdata.getStringupgrade5());
                    break;

                case "8":
                    Butikdata.setStringupgrade6("Legeplads");
                    upgrade6.setText(Butikdata.getStringupgrade6());
                    break;

                case "9":
                    Butikdata.setStringupgrade3("Farve i parksøen");
                    upgrade3.setText(Butikdata.getStringupgrade3());
                    break;

                case "10":
                    Butikdata.setStringupgrade4("Parkeringshus");
                    upgrade4.setText(Butikdata.getStringupgrade4());
                    break;

                case "11":
                    Butikdata.setStringupgrade5("Oliefyr");
                    upgrade5.setText(Butikdata.getStringupgrade5());
                    break;

                case "12":
                    Butikdata.setStringupgrade6("Fodboldstadion");
                    upgrade6.setText(Butikdata.getStringupgrade6());
                    break;

            }
        }

    }

    @FXML
    private void go(MouseEvent event) throws IOException {
        setRootFromEvent(event);
    }

    @FXML
    protected void onOpgraderingerButtonClick() throws IOException{
        setRootFromString("opgraderinger-view");
    }

    @FXML
    protected void onButikTilbageClick() throws IOException  {
        setRootFromString("butik-view");
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
