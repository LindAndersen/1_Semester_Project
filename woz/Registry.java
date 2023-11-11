/* Command registry
 */

import java.util.HashMap;
import java.util.Map;

class Registry {
  Context context;
  Command fallback;
  Map<String, Command> commands = new HashMap<String, Command>();
  
  Registry (Context context, Command fallback) {
    this.context = context;
    this.fallback = fallback;
  }
  
  public void register (String name, Command command) {
    commands.put(name, command);
  }
  
  public void dispatch (String line) {
    String[] elements = line.split(" ");
    String command = elements[0];
    String[] parameters = getParameters(elements);
    Command handler = getCommand(command);
    //So besides checking if command is valid in general, also check if command is available in current Space
    System.out.println(context.getCurrent().getName());
    System.out.println(handler == null);
    System.out.println(!context.getCurrent().isCommandReachable(command));
    (handler==null || !context.getCurrent().isCommandReachable(command) ? fallback : handler).execute(context, command, parameters);
  }
  
  public Command getCommand (String commandName) {
    return commands.get(commandName);
  }
  
  public String[] getCommandNames () {
    return commands.keySet().toArray(new String[0]);
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

