import java.util.Map;

class Kontor extends Space {
<<<<<<< HEAD
    String[] commands = {"exit", "quit", "bye", "go", "help", "status", "save", "load"};
=======
    private boolean isHandled;

    String[] commands = {"exit", "go", "help", "status", "reset"};
>>>>>>> main
    Kontor(String name) {
        super(name);
        isHandled = false;
    }

    void firstDayWelcome() {
        System.out.println("\nVelkommen til kontoret!\n" +
                "Her kan du tjekke din status, inventar, spilletid i dage og de opgraderinger, du har købt til byen.\n" +
                        "Du kan bruge 'status' for at tjekke overstående, og 'help' for at se andre tilgængelige commands i rummet!\n" +
                "God fornøjelse!");
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
    public boolean isCommandReachable(String name) {
        return super.isCommandReachable(name, commands);
    }

    @Override
    public String[] getCommands() {
        return commands;
    }
}