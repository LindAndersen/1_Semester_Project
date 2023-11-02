import java.text.NumberFormat;

public class CommandPickup extends BaseCommand implements Command {
    CommandPickup() {
        this.description = "Saml noget op i rummet";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        int nParam = parameters.length;
        switch (nParam) {
            case 0:
            //If input was "pickup" display trash in room 
                context.getCurrent().showTrash();
                break;
            case 2:
            //If command was "pickup valid_item amount" subtract trash from space and add to player inventory
                try {
                if (context.getCurrent().subtractTrash(parameters[0], Integer.valueOf(parameters[1]))) {
                    context.getPlayer().addToInventory(parameters[0], Integer.valueOf(parameters[1]));
                }
                context.getCurrent().showTrash();
                break;
                //If command was "pickup amount item" catch NumberFormatException and inform user
                //How to properly use the command
                } catch (NumberFormatException e) {
                    System.out.println("Du burde skrive \"pickup [type] [mængde]\"");
                    break;
                //If requested type of trash doesnt exist in room, catch TrashNotFoundException
                } catch (TrashNotFoundException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            default :
            //If command was something not described above
                System.out.println("Det fatter jeg minus af");
                break;
        }

        //System.out.println("Det er så her vi skal implementere logikken");
        //is specified amount of trash available in context.getCurrent().getTrash()
        //Remove trash from current
        //Add trash to player.inventory
        
    }
    
}
