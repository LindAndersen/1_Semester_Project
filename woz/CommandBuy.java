// import java.util.HashMap;
// import java.util.Map;
import java.util.TreeMap;

public class CommandBuy extends BaseCommand implements Command {

    CommandBuy() {
        this.description = "Køb en opgradering";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {

        if(!guardEq(parameters, 0)){
            System.out.println("Du bliver nødt til at sige hvad du vil ha");
        }else{

            if(context.getCurrent() instanceof Butik){//tjek inden downcasting
                Butik butik = (Butik)context.getCurrent();//downcaster Space til Butik, så vi har adgang til metoder i Butik
                TreeMap<String, Upgrades> upgrades = butik.getUpgrades();//henter upgrades og gemmer i en variabel

                Player player = context.getPlayer();


                // int price = 0;//initialiserer price, som skal hentes fra upgrades hvis den angivne uågradde eksisterer
                if(upgrades.containsKey(parameters[0].trim())){//tjekker om den angivne upgrade eksisterer
                    
                    int price = (upgrades.get(parameters[0].trim())).getPrice();//henter pris
                    int xp = (upgrades.get(parameters[0].trim())).getXP();//henter xp

                    if(player.canAfford(price)){//hvis spiller har råd til upgraden...
                        System.out.println("pris: " + price);
                        player.subtractMoney(price);//træk penge
                        player.addXP(xp);//tilføj xp

                        butik.removeUpgrade(parameters[0].trim());//fjern upgrade fra shop

                        //opdater world med ny modifier - ikke implementeret 

                        System.out.println("Du har købt upgraden " + parameters[0]);
                        System.out.println("\n Butikken udvalg er nu: ");
                        butik.showUpgrades();
                        System.out.println("\n Du har så mange mønter nu: " + player.getMoney());
                        System.out.println("Du har så meget xp nu: " + player.getXP() + "\n");

                    }else{
                        System.out.println("Du har ikke råd til denne vare \n");
                    }
                }else{
                   System.out.println("Denne vare er ikke på lager \n");
                }
            }
        }
    }
}


















    // @Override
    // public void execute(Context context, String command, String[] parameters) {
        
    //     if(context.getCurrent() instanceof Butik){//ellers vil getCurrent() gå ind i Space, som ikke har getUpgrades()
    //         Butik butik = (Butik) context.getCurrent();//gemmer current som Butik og ikke Space (downcasting)
    //         ArrayList<Upgrades> upgrades = butik.getUpgrades();//henter upgrades fra butik og gemmer i variabel

    //         ArrayList<String> names = new ArrayList<String>();//gemmer navne på upgrades, så man kan sammenligne med parameters[0]
    //         for(int i = 0; i < upgrades.size(); i++){
    //             names.add(upgrades.get(i).getName().trim().toLowerCase());
    //         }

    //         int price = 0;

    //         for(int i = 0; i < names.size(); i++){//henter prisen hvis upgraden er i udvalget
    //             if(parameters[0].trim().toLowerCase().equals(names.get(i))){
    //                 price = upgrades.get(i).getPrice();
    //             }  
    //         }

    //         if(context.getPlayer().canAfford(price)){//hvis spiller har råd til upgraden...
    //             context.getPlayer().subtractMoney(price);//træk penge
    //             butik.removeUpgrade(parameters[0]);//fjern upgrade fra shop
    //             //opdater world med ny modifier
    //             System.out.println("Du har købt upgraden " + parameters[0]);
    //             System.out.println("Butikken udvalg er nu: " + butik.getUpgrades().toString());
    //         }else{
    //             System.out.println("Du har ikke råd til denne upgrade");
    //         }  
    //     }

