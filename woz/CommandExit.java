/* Command for exiting program
 */

class CommandExit extends BaseCommand implements Command {
  CommandExit() {
    this.description = "Leave the game";
  }
  @Override
  public void execute (Context context, String command, String parameters[]) {
    context.makeDone();
  }
}
