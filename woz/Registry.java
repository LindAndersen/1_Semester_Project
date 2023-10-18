/* Command registry
 */

import java.util.HashMap;
import java.util.Map;

class Registry {
  Context context;
  Command fallback;
  Map<String, Command> commands = new HashMap<String, Command>();
  String[] baseCommands = {"exit", "bye", "quit", "help", "go"};
  
  Registry (Context context, Command fallback) {
    this.context = context;
    this.fallback = fallback;
  }
  
  public void register (String name, Command command) {
    commands.put(name, command);
  }
  
  public void dispatch (String line) {
    String[] elements = line.toLowerCase().split(" ");
    String command = elements[0];
    String[] parameters = getParameters(elements);
    Command handler = getCommand(command);
    ((context.getCurrent().isCommandPossible(command) && handler != null) || isInBaseCommands(command) ? handler : fallback).execute(context, command, parameters);
  }
  
  public Command getCommand (String commandName) {
    return commands.get(commandName);
  }
  
  public String[] getCommandNames () {
    return commands.keySet().toArray(new String[0]);
  }

  public boolean isInBaseCommands(String cmd) {
    for (String command : baseCommands) {
      if (cmd.equals(command)) {return true;}
    } return false;
  }
  
  // helpers
  
  private String[] getParameters (String[] input) {
    String[] output = new String[input.length-1];
    for (int i=0 ; i<output.length ; i++) {
      output[i] = input[i+1];
    }
    return output;
  }
}

