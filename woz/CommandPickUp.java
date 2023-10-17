/* Command for handlign actions in a room
 */

class CommandPickUp extends BaseCommand implements Command {
  CommandPickUp () {
    description = "Pick up an item";
  }
  
  @Override
  public void execute (Context context, String command, String[] parameters) {
    if (guardEq(parameters, 0)) {
      System.out.println("Currently no specific pickup option, just use \"pickup\"");
      return;
    }
    context.roomHandler();
  }
}
