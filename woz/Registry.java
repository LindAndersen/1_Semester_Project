/* Command registry
 */

import java.util.HashMap;
import java.util.Map;

class Registry {
  Context context; 
  Command fallback;
  Map<String, Command> commands = new HashMap<String, Command>(); //key-value map of String name of command and the belonging command

  //Get basecommands from commands
  String[] baseCommands = {"exit", "bye", "quit", "help", "go", "reset", "save", "load"};
  
  Registry (Context context, Command fallback) {
    this.context = context;
    this.fallback = fallback;
  }
  
  public void register (String name, Command command) {
    commands.put(name, command);
  }
  
  public void dispatch (String line) {
    String[] elements = line.toLowerCase().split(" "); //splits the terminal command by " " and puts the strings in an array
    String command = elements[0]; //command is the first element of the array 
    String[] parameters = getParameters(elements); //creates a new array for the parameters from the elements-array
    Command handler = getCommand(command); //retrieves the command from the list of commands
    ((context.getCurrent().isCommandPossible(command) && handler != null) || isInBaseCommands(command) ? handler : fallback).execute(context, command, parameters);
    /*
    ^^ checks if the command is valid (depending on the location), and checks the handler is not empty (there is an actual command)
    or
    if the command is a base command, call execute on handler, otherwise call execute on fallback
    */

  }
  
  public Command getCommand (String commandName) {
    return commands.get(commandName);
  }
  
  public String[] getCommandNames () {
    return commands.keySet().toArray(new String[0]);
  }

  public boolean isInBaseCommands(String cmd) { 
    for (String command : baseCommands) {
      if (cmd.equals(command)) {
        return true;
      }
    } return false;
  }
  
  // helpers
  
  private String[] getParameters (String[] input) {
    //returns a string array containg only the parameters (no command)
    String[] output = new String[input.length-1];
    for (int i=0 ; i<output.length ; i++) {
      output[i] = input[i+1];
    }
    return output;
  }
}

