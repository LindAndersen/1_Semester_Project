class CommandResetDay extends BaseCommand implements Command {
  private World world;

	public CommandResetDay(World world){
		description = "Start en ny dag";
    this.world = world;
	}	
  @Override
  public void execute (Context context, String command, String parameters[]) {
    System.out.println("Resetting the day");
    context.resetDay(world); 
  }
}