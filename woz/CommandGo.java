/* Command for transitioning between spaces
 */

class CommandGo extends BaseCommand implements Command {
  CommandGo () {
    description = "Følg nærmeste udgang";
  }
  
  @Override
  public void execute (Context context, String command, String[] parameters) {
    if (guardEq(parameters, 1)) {
      System.out.println("Uha, hvor vil du hen? 🤔\n");
      System.out.println("Måske skulle du prøve at tage til et af de her steder?\n");
      context.getCurrent().exits();
      return;
    }
    context.transition(parameters[0]);
  }
}
