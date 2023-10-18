/* Command for exiting program
 */

class CommandExit extends BaseCommand implements Command {
	CommandExit() {
		description = "Stop spillet";
	}

  @Override
  public void execute (Context context, String command, String parameters[]) {
    context.makeDone();
  }
}
