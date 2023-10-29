import java.util.Map;

//tilføjet
import java.util.ArrayList;
//.

public class Butik extends Space implements DefaultSpace {

    ArrayList<Upgrades> upgrades;
    
    public Butik(String name) {

        super(name);
        upgrades = getUpgrades();

    }

    @Override
    public void welcome() {
        showUpgrades();
    }

    @Override
    public void goodbye(){

    }



    public ArrayList<Upgrades> getUpgrades(){
        ArrayList<Upgrades> arrL = new ArrayList<Upgrades>();

        arrL.add(new Upgrades("Motorvej", 50, 200, 1.5));
        arrL.add(new Upgrades("Cykelsti", 50, 200, 1.5));
        arrL.add(new Upgrades("Billboard", 50, 200, 1.5));
        arrL.add(new Upgrades("Skraldespande", 50, 200, 1.5));
        arrL.add(new Upgrades("Solceller", 50, 200, 1.5));
        arrL.add(new Upgrades("Filter i parksøen", 50, 200, 1.5));
        arrL.add(new Upgrades("Offentlig transport", 50, 200, 1.5));
        arrL.add(new Upgrades("Isolerende vinduer", 50, 200, 1.5));
        arrL.add(new Upgrades("Legeplads", 50, 200, 1.5));
        arrL.add(new Upgrades("Farve i parksøen", 50, 200, 1.5));
        arrL.add(new Upgrades("Parkeringshus", 50, 200, 1.5));
        arrL.add(new Upgrades("Varmeanlæg m. oliefyr", 50, 200, 1.5));
        arrL.add(new Upgrades("Fodboldstadion", 50, 200, 1.5));

        return arrL;
    }

   

    void showUpgrades() {
        for(Upgrades e : upgrades){
            System.out.println(e.getName());
        }

    }

    void removeUpgrade(String name) {

    }
}
