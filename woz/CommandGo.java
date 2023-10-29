/* Command for transitioning between spaces
 */

class CommandGo extends BaseCommand implements Command {
  CommandGo () {
    description = "Follow an exit";
  }
  
  @Override
  public void execute (Context context, String command, String[] parameters) {
    if (guardEq(parameters, 1)) {
      context.getCurrent().exits();
      return;
    }
    context.transition(parameters[0]);
  }
}
