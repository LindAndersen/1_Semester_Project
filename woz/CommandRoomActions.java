class CommandRoomActions extends BaseCommand implements Command {

	public CommandRoomActions(){
		description = "Acts accordingly dependent on type of room";
	}	



  @Override
  public void execute (Context context, String command, String parameters[]) {

    //her afgøres hvor man befinder sig, og hvad den enkelt kommando gør i de forskellige sammenhænge
    //den skal måske kalde på forskellige handlinger? 
    switch(context.getCurrent().getName()){

    case "Park": 
      System.out.println("hey you are in da park B)");
      break;
    case "Bymidte":
      System.out.println("hey you are in da bymidte B)");
      break;
    case "Hospital":
      System.out.println("hey you are in da hospital B)");
      break;
    case "Genbrugsstation":
      System.out.println("hey you are in da genbrugsstation B)");
      break;
    case "Butik":
      System.out.println("hey you are in da butik B)");
      break;
    default: 
      break;
    }
  }
}