class Park extends Space {
    Trash[] trash = {new Trash("flasker"), new Trash("aviser")};
    String[] commands = {"exit", "quit", "bye", "go", "help", "pickup"};

    Park(String name) {
        super(name);
    }

    public void showTrash() {
        super.showTrash(trash);
    }

    public void welcome() {
        super.welcome();
    }

    public boolean subtractTrash(String name, int amount) {
        return super.subtractTrash(name, amount, trash);
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