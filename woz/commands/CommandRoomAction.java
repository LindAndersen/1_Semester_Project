/* Command for handlign actions in a room
 */
class CommandRoomAction extends BaseCommand implements Command {

  Player player;


  CommandRoomAction (String description) {
    super(String.format("Rumhandlinger: %s", description));
    player = Game.context.getPlayer();

  }


  public void pickup(Context context, String[] parameters) {
    
    //we get the player, our current location and the amount of trash present
    Space cspace = context.getCurrent();
    int amountPresent = cspace.getGeneratedTrash();

    //if the pickup-command has 1 parameter (amount of trash to collect) we do as follows
    if (!guardEq(parameters, 1)) {
      int amount = Integer.parseInt(parameters[0]); //parameters[] is a string array which we convert to int
      
      if (amount > amountPresent) {//if you ask to collect more trah than present:
        System.out.printf("%nSå meget skrald er der ikke! Der er %d", amountPresent);
      } 
      else {//otherwise we add the trash to inventory and set the amount of trash in the location after pickup
        player.addToInventory("trash", amount);
        cspace.setGeneratedTrash(amountPresent - amount);
        System.out.printf("%nDu har samlet %d skrald op - nu har du " + player.getInventory() + " i din taske!", amount);
      }
    }
    else if (!guardEq(parameters, 0)) {//if you only type "pickup":
      player.addToInventory("trash", amountPresent);
      cspace.setGeneratedTrash(0);
      System.out.printf("%nDu har samlet alt skrald op - nu har du " + player.getInventory() + " i din taske!");
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

  //Buy command can be executed from shop (butik). this is checked in registry w baseCommands and roomCommands
  public void buy(Context context, String[] parameters) {
    if (guardEq(parameters, 1)) {
      context.youStupid();
      return;
    }
    context.buyExecuter(parameters);//calls buyExecuter from context who will peform the necessary actions

  }

  //command to sell trash valid in shop (shouldn't it be valid at genbrugsstation only?)
  public void sell(Context context, String[] parameters) {
    if (guardEq(parameters, 1)) {
      context.youStupid();
      return;
    }else{
      player.removeFromInventory("trash", Integer.parseInt(parameters[0]));
      System.out.println(player.getInventory());
    }
    System.out.printf("%nDu har solgt %s bunker skrald%n", parameters[0]);
  }


  //default action for commands
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
