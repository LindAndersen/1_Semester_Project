class Villakvarter extends Space {
    String[] commands = {"exit", "go", "help", "pickup", "reset"};

    Villakvarter(String name) {
        super(name);
    }

    public void welcome() {
        //Make own welcome specific for Rækkehuse
        super.welcome();
    }

    @Override
    public boolean isCommandReachable(String name) {
        return super.isCommandReachable(name, commands);
    }

    @Override
    public String[] getCommands() {
        return commands;
    }

    @Override
    public void showTrash() {
        super.showTrash(super.getTrash());
    }
}