public class CommandRecycle extends BaseCommand implements Command {
    CommandRecycle() {
        this.description = "Genbrug fra din inventar";
    }

    //Handle recycling of trash
    @Override
    public void execute(Context context, String command, String[] parameters) {
        /*if player has enough trash in inventory to hand in specified amount (from console):
            Remove amount from player inventory - context.getPlayer().getInventory().removeFromInventory("name / key").
            Give player the appropriate amount of XP and coins - context.getPlayer().addXP(amount) & context.getPlayer().addCoins(amount)
        */

    }
    
}
