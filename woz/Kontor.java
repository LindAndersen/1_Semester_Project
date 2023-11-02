import java.util.Map;
import java.io.Serializable;

class Kontor extends Space implements Serializable {
    String[] commands = {"exit", "quit", "bye", "go", "help", "status", "save", "load"};

    public Kontor(String name) {
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