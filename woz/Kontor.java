import java.util.Map;

class Kontor extends Space {
    String[] commands = {"exit", "quit", "bye", "go", "help", "status"};
    Kontor(String name) {
        super(name);
    }

    void firstDayWelcome() {
        System.out.println("Velkommen til kontoret!");
        System.out.println("Her kan du tjekke din status, inventar, spilletid i dage og de opgraderinger, du har købt til byen.");
        System.out.println("God fornøjelse!");
    }
    @Override
    public void welcome() {
        //Specify welcome for Kontor
        super.welcome();
    }

    @Override
    public void showTrash() {
        //No trash here
    }

    public void setRoomTrash(){
       //No trash here
    }

    @Override
    public boolean isCommandReachable(String name) {
        return super.isCommandReachable(name, commands);
    }

    @Override
    public String[] getCommands() {
        return commands;
    }
}