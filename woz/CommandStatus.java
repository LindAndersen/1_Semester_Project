public class CommandStatus extends BaseCommand implements Command {

    CommandStatus() {
        this.description = "Se en oversigt over hvordan din by klarer det";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        System.out.println("STATUS");
        System.out.println("Lvl: " + context.getPlayer().getLvl());
        System.out.println("XP: " + context.getPlayer().getXP() + "/100"); //tallet skal være hvor meget XP der er ved hver level
        System.out.println("Bankkonto: " + context.getPlayer().getMoney());
        System.out.println("Inventar: \n" + context.getPlayer().getInventory());
    }
    
}
