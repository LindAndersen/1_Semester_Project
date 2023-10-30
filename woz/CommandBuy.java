import java.util.ArrayList;
public class CommandBuy extends BaseCommand implements Command {

    CommandBuy() {
        this.description = "Buy an upgrade";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        System.out.println("in da shop");
        // ArrayList<Upgrades> upgrades = context.getCurrent().getUpgrades();
        // int price = upgrades.get(i).getPrice();


        // for(Upgrades upgrade : upgrades){
        //     if(upgrade.get(i).getName().equalsIgnoreCase(parameters[0])){
        //         context.getPlayer().canAfford(price);
        //         context.getPlayer().subtractMoney(price);
        //         context.getCurrent().removeUpgrade(parameters[0]);
        //     }else{
        //         System.out.println("Denne upgrade er ikke på lager");
            
        //     }


        
        // }

        /*  if player can afford the upgrade - context.getPlayer().canAfford()
            Call a buy() method that subtracts money from player - context.getPlayer().subtractMoney(amount)
            Removes upgrade from shop - context.getCurrent().removeFromShop("upgrade name / key")

            In some way adds the upgrade to the world /updates world and activates changes 
        */
    }
}