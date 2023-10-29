import java.util.Map;

class Rådhusplads extends Space {
    String[] commands = {"exit", "quit", "bye", "go", "help", "pickup"};
    Trash[] trash = {new Trash("flasker"), new Trash("aviser")};

    Rådhusplads(String name) {
        super(name);
    }

    @Override public void welcome() {
        //Make own welcome for Rådshusplads
        super.welcome();
    }

    public String[] getCommands() {
        return commands;
    }

    public boolean isCommandReachable(String name) {
        return (boolean) super.isCommandReachable(name, commands);
    }


    public void subtractTrash(String name, int amount) {
        super.subtractTrash(name, amount, trash);
    }

    public void showTrash() {
        super.showTrash(trash);
    }
}