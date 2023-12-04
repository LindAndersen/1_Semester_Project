package com.genbrugsstation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class ButikController extends SharedGUIFunc {


    @FXML
    private Button cykelsti, solceller, filter, bus, vinduer, leg, motor, bill, farve, parkering, olie, bold, back;
    @FXML
    private Label pengetext, xptext, upgrade1, upgrade2, upgrade3, upgrade4, upgrade5, upgrade6, lolatekst;

    @FXML
    private ImageView imageview_græslvl0, imageview_græslvl1, imageview_græslvl2, imageview_græslvl3, imageview_græslvl4, imageview_græslvl5;
    
    private static final Map<String, Integer> upgradeIndexMap = new LinkedHashMap<>();

    static {
        upgradeIndexMap.put("1", 0);
        upgradeIndexMap.put("2", 0);
        upgradeIndexMap.put("3", 1);
        upgradeIndexMap.put("4", 3);
        upgradeIndexMap.put("5", 1);
        upgradeIndexMap.put("6", 2);
        upgradeIndexMap.put("7", 4);
        upgradeIndexMap.put("8", 5);
        upgradeIndexMap.put("9", 2);
        upgradeIndexMap.put("10", 3);
        upgradeIndexMap.put("11", 4);
        upgradeIndexMap.put("12", 5);
    }

    private ImageView[] grass;

    @FXML
    public void initialize(){
        grass = new ImageView[] {imageview_græslvl0, imageview_græslvl1, imageview_græslvl2, imageview_græslvl3, imageview_græslvl4, imageview_græslvl5};

        if (pengetext != null && xptext != null) {
            pengetext.setText("Du har " + context.getPlayer().getMoney() + " kr.");
            xptext.setText("Du har " + context.getPlayer().getXP() + " xp.");

            if (upgrade1 != null && upgrade2 != null && upgrade3 != null && upgrade4 != null && upgrade5 != null && upgrade6 != null){

                updateupgradetext();

                for (int i = 0; i < 6; i++) {
                    switch (Butikdata.getStringUpgrade(i)) {
                        case "":
                            break;

                        case "Cykelsti", "Motorvej":
                            setButtonDisable(cykelsti, motor);
                            break;

                        case "Solceller", "Billboards":
                            setButtonDisable(solceller, bill);
                            break;

                        case "Filter i parksøen", "Farve i parksøen":
                            setButtonDisable(filter, farve);
                            break;

                        case "Busstoppested", "Parkeringshus":
                            setButtonDisable(bus, parkering);
                            break;

                        case "Isolerende vinduer", "Varmeanlæg m. oliefyr":
                            setButtonDisable(vinduer, olie);
                            break;

                        case "Legeplads", "Fodboldstadion":
                            setButtonDisable(leg, bold);
                            break;
                    }
                }
            }
        }

        if (imageview_græslvl0 != null) {
            updateSceneFromLevel();
        }

    }

    private void updateSceneFromLevel() {
        int lvl = player.getLvl();
        for (int i = 0;i<grass.length;i++) {
            if (lvl == i) {
                grass[i].setOpacity(1);
            } else {
                grass[i].setOpacity(0);
            }
        }
    }

    public void setButtonDisable(Button a, Button b){
        a.setDisable(true);
        b.setDisable(true);
    }

    public void updateupgradetext(){
        upgrade1.setText(Butikdata.getStringUpgrade(0));
        upgrade2.setText(Butikdata.getStringUpgrade(1));
        upgrade3.setText(Butikdata.getStringUpgrade(2));
        upgrade4.setText(Butikdata.getStringUpgrade(3));
        upgrade5.setText(Butikdata.getStringUpgrade(4));
        upgrade6.setText(Butikdata.getStringUpgrade(5));
    }


    public void upgradeButtonClick(String a, Button c, Button d){
        int oldMoney = player.getMoney();

        int[] prices = new int[12];

        int[] xp = new int [12];

        String[] names = new String[12];
        String[] hints = new String[12];

        for (int i = 1; i <= 12; i++) {
            prices[i - 1] = Butik.getUpgradePrice(i);
            names[i - 1] = Butik.getUpgradeName(i);
            xp[i - 1] = Butik.getUpgradeXp(i);
            hints[i-1] = Butik.getHints(i);
        }

        String tillykke = "Tillykke du har købt opgraderingen ";

        String[] forklaring = {
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

        int newMoney = player.getMoney();
        if (oldMoney != newMoney) {
            setButtonDisable(c,d);
            pengetext.setText("Du har " + context.getPlayer().getMoney() + " kr.");
            xptext.setText("Du har " + context.getPlayer().getXP() + " xp.");

            String upgradeText = String.format(
                    "%s%s til byen! %s Den kostede %d kr. og gav %d xp. Om %s: %s",
                    tillykke, names[upgradeIndex], forklaring[upgradeIndex], prices[upgradeIndex], xp[upgradeIndex], names[upgradeIndex], hints[upgradeIndex]
            );

            Butikdata.setStringUpgrade(upgradeIndexMap.getOrDefault(a, -1), names[upgradeIndex]);
            updateupgradetext();
            lolatekst.setText(upgradeText);
        } else{
            lolatekst.setText("Du har desværre ikke råd til denne opgradering. :(");
        }

        if(player.getBuyCount() == 6){
            try {
                setRootFromString("game-over-view");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    @FXML
    private void go(MouseEvent event) throws IOException{
        setRootFromEvent(event);
    }

    @FXML
    protected void onOpgraderingerButtonClick(){
        setRootFromString("opgraderinger-view");
    }

    @FXML
    protected void onButikTilbageClick() {
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
    protected void onInfoButtonClick() throws IOException {
        System.out.println("menu åbner");

        Game.setRoot("default-menu-view");
    }

    @FXML
    protected void onInfoButtonOpgraderingClick(ActionEvent event) throws IOException {
        lolatekst.setText("Opgraderingerne er delt op i tiers fra 1 til 6. Du kan kun købe 1 opgradering fra hvert tier.");
    }

}
