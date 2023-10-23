/* Baseclass for commands
 */

class BaseCommand {
  String description;

  BaseCommand(String description) {
  	this.description = description;
  }

  BaseCommand() {
  	description = "Undocumented";
  }
  
  protected boolean guardEq (String[] parameters, int bound) {
    return parameters.length!=bound;
  }
  
  public String getDescription () {
    return description;
  }
}
