import java.util.HashMap;
import java.util.Map;
public class CommandBuy extends BaseCommand implements Command {

    CommandBuy() {
        this.description = "Buy an upgrade";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {

        /*  if player can afford the upgrade - context.getPlayer().canAfford()
            Call a buy() method that subtracts money from player - context.getPlayer().subtractMoney(amount)
            Removes upgrade from shop - context.getCurrent().removeFromShop("upgrade name / key")

            In some way adds the upgrade to the world /updates world and activates changes 
        */

        if(context.getCurrent() instanceof Butik){//tjek inden downcasting
            Butik butik = (Butik)context.getCurrent();//downcaster Space til Butik, så vi har adgang til metoder i Butik
            HashMap<String, Upgrades> upgrades = butik.getUpgrades();//henter upgrades og gemmer i en variabel
            
            int price = 0;//initialiserer price, som skal hentes fra upgrades hvis den angivne uågradde eksisterer
            
            if(upgrades.containsKey(parameters[0].trim())){//tjekker om den angivne upgrade eksisterer
                price = upgrades.get(parameters[0].trim()).getPrice();//henter pris
            }else{
                System.out.println("Denne vare er ikke på lager");
            }

            if(context.getPlayer().canAfford(price)){//hvis spiller har råd til upgraden...
                context.getPlayer().subtractMoney(price);//træk penge
                butik.removeUpgrade(parameters[0].trim());//fjern upgrade fra shop

                //opdater world med ny modifier - ikke implementeret 

                System.out.println("Du har købt upgraden " + parameters[0]);
                System.out.println("Butikken udvalg er nu: ");
                butik.showUpgrades();
                System.out.println("Du har så mange coins nu: " + context.getPlayer().getMoney());
            }else{
                System.out.println("Du har ikke råd til denne upgrade");
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

