/* Help command
 */

import java.util.Arrays;

class CommandHelp extends BaseCommand implements Command {
  Registry registry;
  
  CommandHelp (Registry registry) {
    this.registry = registry;
    this.description = "Viser en liste over kommandoer tilgængelige i rummet";
  }
  
  @Override public void execute(Context context, String command, String[] parameters) {

    //Instead of getting commands from registry, get directly from room
    //This way the help command only displays currently available commands
    String[] commands = context.getCurrent().getCommands();

    // find max length of command name
      int max = 0;
      for (String commandName: commands) {
        int length = commandName.length();
        if (length>max) {
          max = length;
        }
      }
      // present list of commands
      System.out.println("\n Kommandoer:");
      for (String commandName: commands) {
        String description = registry.getCommand(commandName).getDescription();
        System.out.printf(" - %-"+max+"s %s%n", commandName, description, "\n");
    }
  }


  /*
    * @Override
    public void execute (Context context, String command, String[] parameters) {
      String[] commandNames = registry.getCommandNames();
      Arrays.sort(commandNames);
      
  }
   */
  
}
