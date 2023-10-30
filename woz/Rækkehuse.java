class Rækkehuse extends Space {
    String[] commands = {"exit", "quit", "bye", "go", "help", "pickup"};
    Trash[] trash = {new Trash("flasker"), new Trash("aviser")};

    Rækkehuse(String name) {
        super(name);
        //Add some trash to trash
    }

    public void welcome() {
        //Make own welcome specific for Rækkehuse
        super.welcome();
    }

    @Override
    public void showTrash() {
        super.showTrash(trash);
    }

    @Override
    public void subtractTrash(String name, int amount) {
        super.subtractTrash(name, amount, trash);
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