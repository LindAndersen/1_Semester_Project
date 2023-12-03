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
    private Label pengetext, xptext, upgrade1, upgrade2, upgrade3, upgrade4, upgrade5, upgrade6, lolatekst;

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
                        setButtonDisable(cykelsti,motor);
                        break;

                }
                upgrade2.setText(Butikdata.getStringupgrade2());
                switch (Butikdata.getStringupgrade2()) {
                    case "":
                        break;

                    case "Solceller":
                        setButtonDisable(solceller,bill);
                        break;

                }
                upgrade3.setText(Butikdata.getStringupgrade3());
                switch (Butikdata.getStringupgrade3()) {
                    case "":
                        break;

                    case "Filter i parksøen":
                        setButtonDisable(filter,farve);
                        break;

                }
                upgrade4.setText(Butikdata.getStringupgrade4());
                switch (Butikdata.getStringupgrade4()) {
                    case "":
                        break;

                    case "Busstoppested":
                        setButtonDisable(bus,parkering);
                        break;

                }
                upgrade5.setText(Butikdata.getStringupgrade5());
                switch (Butikdata.getStringupgrade5()) {
                    case "":
                        break;

                    case "Isolerende vinduer":
                        setButtonDisable(vinduer,olie);
                        break;

                }
                upgrade6.setText(Butikdata.getStringupgrade6());
                switch (Butikdata.getStringupgrade6()) {
                    case "":
                        break;

                    case "Legeplads":
                        setButtonDisable(leg,bold);
                        break;

                }
            }
        }

    }

    public void setButtonDisable(Button a, Button b){
        a.setDisable(true);
        b.setDisable(true);
    }


    public void upgradeButtonClick(String a, Button c, Button d){
        int oldMoney = player.getMoney();

        int[] prices = new int[12];

        int[] xp = new int [12];

        String[] names = new String[12];

        for (int i = 1; i <= 12; i++) {
            prices[i - 1] = Butik.getUpgradePrice(i);
            names[i - 1] = Butik.getUpgradeName(i);
            xp[i - 1] = Butik.getUpgradeXp(i);
        }

        String tillykke = new String("Tillykke du har købt opgraderingen ");

        String[] forklaring = new String[]{
                "Cykelstier hjælper folk med at komme sikkert og klimavenligt rundt i byen!",
                "Motorvejen hjælper folk med at komme hurtigt igennem byen, men mindsker gåbarheden og øger støjen og klimaforureningen i byen!",
                "Billboards hjælper virksomheder med at reklamere, men øger lysforureningen og klimaforureningen i byen!",
                "Busstoppestedet hjælper folk, især handicappede, med at komme sikkert og klimavenligt rundt i byen!",
                "Solceller hjælper folk i byen med klimavenligt at genere strøm til deres forbrug!",
                "Filteret i parksøen hjælper med at rense søen og øger helbreddet for det naturlige dyreliv i byen!",
                "Isolerende vinduer hjælper folk med at mindske deres varmeudgift og sænker klimaforureningen i byen!",
                "Legepladsen øger glæden og trivslen af børnefamilier i byen!",
                "Farven i parksøen ser sejt ud, men forurener naturområdet og er dårligt for det naturlige dyreliv i byen!",
                "Parkeringshuset hjælper folk med at finde en parkeringsplads, men øger brugen af biler i byen og derfor klimaforureningen!",
                "Varmeanlægget med oliefyr hjælper folk med billigt at varme boligen op, men er meget dårligt for klimaet og luftkvaliteten i byen!",
                "Fodboldstadionet hjælper folk med at se mere fodbold, men øger støjen, traffikken og lysforureningen i området!"
        };

        int upgradeIndex = Integer.parseInt(a) - 1;

        player.buy(a, context);

        int newMoney = context.getPlayer().getMoney();
        if (oldMoney != newMoney) {
            setButtonDisable(c,d);
            pengetext.setText("Du har " + context.getPlayer().getMoney() + " kr.");
            xptext.setText("Du har " + context.getPlayer().getXP() + " xp.");

            String upgradeText = String.format(
                    "%s%s til byen! %s Den kostede %d kr. og gav %d xp.",
                    tillykke, names[upgradeIndex], forklaring[upgradeIndex], prices[upgradeIndex], xp[upgradeIndex]
            );

            switch (a) {
                case "1":
                    Butikdata.setStringupgrade1("Cykelsti");
                    upgrade1.setText(Butikdata.getStringupgrade1());
                    lolatekst.setText(upgradeText);
                    break;

                case "2":
                    Butikdata.setStringupgrade1("Motorvej");
                    upgrade1.setText(Butikdata.getStringupgrade1());
                    lolatekst.setText(upgradeText);
                    break;

                case "3":
                    Butikdata.setStringupgrade2("Billboards");
                    System.out.println("Sætter string upgrade til billboard");
                    upgrade2.setText(Butikdata.getStringupgrade2());
                    lolatekst.setText(upgradeText);
                    break;

                case "4":
                    Butikdata.setStringupgrade4("Busstoppested");
                    upgrade4.setText(Butikdata.getStringupgrade4());
                    lolatekst.setText(upgradeText);
                    break;

                case "5":
                    Butikdata.setStringupgrade2("Solceller");
                    upgrade2.setText(Butikdata.getStringupgrade2());
                    lolatekst.setText(upgradeText);
                    break;

                case "6":
                    Butikdata.setStringupgrade3("Filter i parksøen");
                    upgrade3.setText(Butikdata.getStringupgrade3());
                    lolatekst.setText(upgradeText);
                    break;

                case "7":
                    Butikdata.setStringupgrade5("Isolerende vinduer");
                    upgrade5.setText(Butikdata.getStringupgrade5());
                    lolatekst.setText(upgradeText);
                    break;

                case "8":
                    Butikdata.setStringupgrade6("Legeplads");
                    upgrade6.setText(Butikdata.getStringupgrade6());
                    lolatekst.setText(upgradeText);
                    break;

                case "9":
                    Butikdata.setStringupgrade3("Farve i parksøen");
                    upgrade3.setText(Butikdata.getStringupgrade3());
                    lolatekst.setText(upgradeText);
                    break;

                case "10":
                    Butikdata.setStringupgrade4("Parkeringshus");
                    upgrade4.setText(Butikdata.getStringupgrade4());
                    lolatekst.setText(upgradeText);
                    break;

                case "11":
                    Butikdata.setStringupgrade5("Oliefyr");
                    upgrade5.setText(Butikdata.getStringupgrade5());
                    lolatekst.setText(upgradeText);
                    break;

                case "12":
                    Butikdata.setStringupgrade6("Fodboldstadion");
                    upgrade6.setText(Butikdata.getStringupgrade6());
                    lolatekst.setText(upgradeText);
                    break;

            }
        }
        else{
            lolatekst.setText("Du har desværre ikke råd til denne opgradering. :(");
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
    @FXML
    protected void onInfoButtonClick(ActionEvent event) throws IOException {
        System.out.println("menu åbner");
        try {
            Game.setRoot("default-menu-view");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void onInfoButtonOpgraderingClick(ActionEvent event) throws IOException {
        lolatekst.setText("Opgraderingerne er delt op i tiers fra 1 til 6. Du kan kun købe 1 opgradering fra hvert tier. " +
                "Opgraderingerne til venstre giver dobbelt så meget xp som dem til højre, men koster 20 kr. mere. " +
                "Prisen i tier 1 er 100 kr. for dem til højre og stiger med 20 kr. for hvert tier man går ned for både opgraderingerne til højre og venstre.");
    }

}
