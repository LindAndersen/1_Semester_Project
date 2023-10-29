import java.text.NumberFormat;

public class CommandPickup extends BaseCommand implements Command {
    CommandPickup() {
        this.description = "Saml noget op";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        int nParam = parameters.length;
        switch (nParam) {
            case 0:
                context.getCurrent().showTrash();
                break;
            case 2:
                try {
                context.getCurrent().subtractTrash(parameters[0], Integer.valueOf(parameters[1]));
                context.getPlayer().addToInventory(parameters[0], Integer.valueOf(parameters[1]));
                context.getCurrent().showTrash();
                break;
                } catch (NumberFormatException e) {
                    System.out.println("Du burde skrive \"pickup [type] [mængde]\"");
                    break;
                }
            default :
                System.out.println("Det fatter jeg minus af");
                break;
        }

        //System.out.println("Det er så her vi skal implementere logikken");
        //is specified amount of trash available in context.getCurrent().getTrash()
        //Remove trash from current
        //Add trash to player.inventory
        
    }
    
}
