import java.util.Map;

class Kontor extends Space {
    String[] commands = {"exit", "quit", "bye", "go", "help", "status"};
    Kontor(String name) {
        super(name);
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
    public boolean subtractTrash(String name, int amount) {
        return false;
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