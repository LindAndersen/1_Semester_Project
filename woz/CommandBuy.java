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
    }
    
}
