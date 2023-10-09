/* Command for transitioning between spaces
 */

class CommandGo extends BaseCommand implements Command {
  CommandGo () {
    description = "Follow an exit";
  }
  
  @Override
  public void execute (Context context, String command, String[] parameters) {
    if (guardEq(parameters, 1)) {
      System.out.println("I don't seem to know where that is 🤔");
      return;
    }
    context.transition(parameters[0]);
  }
}
