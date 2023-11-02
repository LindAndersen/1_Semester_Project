import java.util.Map;

class Kontor extends Space {
    private boolean isHandled;

    String[] commands = {"exit", "quit", "bye", "go", "help", "status", "reset"};
    Kontor(String name) {
        super(name);
        isHandled = false;
    }

    @Override
    public void welcome() {
        //Specify welcome for Kontor
        super.welcome();
        makeHandled();
    }

    @Override
    public void showTrash() {
        //No trash here
    }

    @Override
    public void makeHandled(){
        isHandled = true;
    }

    @Override
    public void undoHandled(){
        isHandled = false;
    }

    @Override
    public boolean getHandled(){
        return isHandled;
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