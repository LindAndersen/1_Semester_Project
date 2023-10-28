public class CommandPickup extends BaseCommand implements Command {
    CommandPickup() {
        this.description = "Saml noget op";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        //is specified amount of trash available in context.getCurrent().getTrash()
        //Remove trash from current
        //Add trash to player.inventory
        
    }
    
}
