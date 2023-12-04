package com.genbrugsstation;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.Window;
import javafx.stage.WindowEvent;


public class GameOverController extends SharedGUIFunc {

    private Stage stage;

    @FXML
    private Button leaveSaveBtn, backToGameBtn;
    @FXML
    private TextArea text;

    public void initialize(){
        setTextField();
    }

    private void setTextField(){
        Player player = context.getPlayer();
        switch (player.getLvl()){
            case 1:
                text.setText("Du sluttede på level 1;\n" +
                        "Uha, det var ikke så godt borgmester… Trods den stærke indsats og dit "+
                        "hårde arbejde, endte du på level 1!"+
                        "Byens bæredygtighed har ikke udviklet sig meget, og kunne stadig have gavn "+
                        "af en kærlig hånd. Men tvivl dog ikke, for du har potentiale! Med bedre "+
                        "opgraderinger og bedre effektive valg, kan du tage i lære og næste gang tage "+
                        "byen i en grønnere retning.\n"+
                        "Bedre held næste gang!");
                break;
            case 2:
                text.setText("Du sluttede på level 2;\n"+
                        "Det var ikke helt dårligt, borgmester! Efter dit arbejde endte spillet på level 2!"+
                        "Du har allerede nu som borgmester taget nogle vigtige skridt i den rigtige retning. "+
                        "Byens bæredygtighed har udviklet sig en smule siden begyndelsen, men der er stadig lang "+
                        "vej endnu, og mere arbejde at gøre!"+
                        "Men mon ikke næste gang du spiller, at græsset kunne blive lidt grønnere? \n"+
                        "Lær af din nye viden og prøv igen!");
                break;
            case 3:
                text.setText("Du sluttede på level 3;\n"+
                        "Sådan borgmester! Du sluttede spillet på level 3!"+
                        "Byen begynder at virke både grønnere og mere bæredygtig! De nye løsninger "+
                        "og opgraderinger kan anes på byen, og byen er også blevet pænere i takt med, "+
                        "at mere skrald er forsvundet fra gaderne. Men det er ikke slut, borgmester, for "+
                        "der er stadig plads til forbedringer, så du kan nå helt til top!\n"+
                        "Fortsæt med at forsøge, og se om du ikke kan score højere?");
                break;
            case 4:
                text.setText("Du sluttede på level 4;\n" +
                        "Fantastisk arbejde borgmester! Du sluttede spillet på level 4!"+
                        "Byen ser frem til en mere bæredygtig fremtid, og med grønnere græs "+
                        "og flere dyr i byen, kan man virkelig fornemme forskellen! Der er stadig "+
                        "mere at gøre for byen, men din indsats har allerede gjort en stor positiv forskel!\n"+
                        "Fortsæt det gode arbejde, og se om du ikke kan ramme toppen fuldstændig?");
                break;
            case 5:
                text.setText("Du sluttede på level 5;\n"+
                        "Det var da en ekstraordinær succes borgmester! Du nåede hele vejen til "+
                        "top på level 5! Byen blomstrer takket være dig og dine beslutninger, og "+
                        "beboerne er dig evigt taknemmelige. Ikke nok med at dine bæredygtige valg "+
                        "har påvirket byen, er det også blevet en standard for global bæredygtighed! "+
                        "Det er en grøn fremtid i vente for denne by! \n"+
                        "Tak for din indsats, og fortsæt det gode arbejde!");
                break;
        }
    }

    @FXML
    protected void backToGamePressed(){
        try {
            setRootFromString("opgraderinger-view");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    protected void leaveSavePressed(ActionEvent event){
        Game.save_game();
        try{
            EventHandler<WindowEvent> closeAll = new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    Platform.exit();
                }
            };

            Node n = (Node)event.getSource();
            Scene s = n.getScene();
            stage = (Stage)s.getWindow();

            Window w = s.getWindow();
            w.setOnHidden(closeAll);
            stage.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
