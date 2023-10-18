/* Command for handlign actions in a room
 */

class CommandRoomAction extends BaseCommand implements Command {
  CommandRoomAction (String description) {
    super(String.format("Rumhandlinger: %s", description));
  }

  public void pickup(Context context, String[] parameters) {
    if (!guardEq(parameters, 1)) {
      String amount = parameters[0];
      System.out.printf("%nDu har samlet %s bunker skrald op", amount);
      return;
    } else if (!guardEq(parameters, 0)) {
      System.out.println("Du har samlet alt skrald op");
    } else {
      context.youStupid();
    }

  }

  public void hint(Context context, String[] parameters) {
    if (guardEq(parameters, 0)) {
      context.youStupid();
      return;
    }
    System.out.println("Congratulations, you have recieved a hint");
  }

  public void default_(Context context, String command, String[] parameters) {
    if (guardEq(parameters, 0)) {
      context.youStupid();
      return;
    }
    System.out.println("Have not implemented that command yet :))");
  }
  
  @Override
  public void execute (Context context, String command, String[] parameters) {
    switch(command) {

      case "pickup" :
        pickup(context, parameters);
        break;

      case "hint" :
        hint(context, parameters);
        break;
        
      default :
        default_(context, command, parameters);

    }    
  }
}
