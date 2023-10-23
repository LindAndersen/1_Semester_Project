/* Command for handlign actions in a room
 */

class CommandRoomAction extends BaseCommand implements Command {
  CommandRoomAction (String description) {
    super(String.format("Rumhandlinger: %s", description));
  }

  public void pickup(Context context, String[] parameters) {
    Player player = context.getPlayer();
    Space cspace = context.getCurrent();
    int amountPresent = cspace.getGeneratedTrash();

    if (!guardEq(parameters, 1)) {
      int amount = Integer.parseInt(parameters[0]);
      if (amount > amountPresent) {
        System.out.printf("%nSå meget skrald er der ikke! Der er %d", amountPresent);
      } else {
        player.addTrash(amount);
        cspace.setGeneratedTrash(amountPresent - amount);

        System.out.printf("%nDu har samlet %d skrald op - nu har du %d i din taske!", amount, player.getTrash());
      }
    }
    else if (!guardEq(parameters, 0)) {
      player.addTrash(amountPresent);
      cspace.setGeneratedTrash(0);
      System.out.printf("%nDu har samlet alt skrald op - nu har du %d i din taske!", player.getTrash());
    } else {
      context.youStupid();
    }
  }

  // Hint can be called from everywhere
  public void hint(Context context, String[] parameters) {
    if (guardEq(parameters, 0)) {
      context.youStupid();
      return;
    }
    System.out.println("Congratulations, you have recieved a hint");
  }

  //Buy command can be executed from shop (butik) this is checked in registry w baseCommands and roomCommands
  public void buy(Context context, String[] parameters) {
    if (guardEq(parameters, 1)) {
      context.youStupid();
      return;
    }
    context.buyExecuter(parameters);

  }

  public void sell(Context context, String[] parameters) {
    if (guardEq(parameters, 1)) {
      context.youStupid();
      return;
    }
    System.out.printf("%nDu har solgt %s bunker skrald%n", parameters[0]);
  }


  public void default_(Context context, String command, String[] parameters) {
    if (guardEq(parameters, 0)) {
      context.youStupid();
      return;
    }
    System.out.println("From default: Have not implemented that command yet :))");
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

      case "sell" :
        sell(context, parameters);
        break;

      case "buy" :
        buy(context, parameters);
        break;
        
      default :
        default_(context, command, parameters);

    }    

    context.getCurrent().welcome();
  }
}
