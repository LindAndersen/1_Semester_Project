class Genbrugsstation extends Space {
    Trash[] trash = {new Trash("metalskrot"), new Trash("batterier"), new Trash("plastik")};
    String[] commands = {"exit", "quit", "bye", "go", "help", "pickup", "recycle"};

    Genbrugsstation(String name) {
        super(name);
    }

    @Override public void showTrash() {
        super.showTrash(trash);
    }

    @Override public void subtractTrash(String name, int amount) {
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