/* Command for transitioning between spaces
 */

class CommandGo extends BaseCommand implements Command {
  CommandGo () {
    description = "Follow an exit";
  }
  
  @Override
  public void execute (Context context, String command, String[] parameters) {
    if (guardEq(parameters, 1)) {
      System.out.println("Uha, hvor vil du hen? 🤔");
      System.out.println("Måske skulle du prøve at tage til et af de her steder?");
      context.getCurrent().exits();
      return;
    }
    context.transition(parameters[0]);
  }
}
