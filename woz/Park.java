class Park extends Space {
<<<<<<< HEAD
    static String[] commands = {"exit", "quit", "bye", "go", "help", "pickup"};

=======
    String[] commands = {"exit", "go", "help", "pickup", "reset"};
 
>>>>>>> main
    Park(String name) {
        super(name);
    }

    public void welcome() {
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