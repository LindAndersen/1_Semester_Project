package com.example.kontorgui;

class CommandResetDay extends BaseCommand implements Command {
  private World world;
 
	public CommandResetDay(World world){
		description = "Start en ny dag";
    this.world = world;
	}	
  @Override
  public void execute (Context context, String name) {
    System.out.println("command reset execute");

        context.resetDay(world);
  }
}