class CommandResetDay extends BaseCommand implements Command {

	public CommandResetDay(){
		description = "Reset the day";
	}	
  @Override
  public void execute (Context context, String command, String parameters[]) {
    System.out.println("Resetting the day");
    Game.context.resetDay();
  }
}