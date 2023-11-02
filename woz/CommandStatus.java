public class CommandStatus extends BaseCommand implements Command {

    CommandStatus() {
        this.description = "Se en oversigt over hvordan din by klarer det";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {

        int lvl = context.getPlayer().getLvl();

        System.out.println("STATUS");
        System.out.println("By Level: " + context.getPlayer().getLvl());
        System.out.println("XP: " + context.getPlayer().remainingXP() + "/100"); //tallet skal være hvor meget XP der er ved hver level
        System.out.println("Bankkonto: " + context.getPlayer().getMoney() + " mønter");
        System.out.println("Inventar: \n" + context.getPlayer().getInventory().getItems());
        System.out.println("Dag: " + context.getDay());

        //mangler at få en liste af de upgrades man har købt
    }
    
}
