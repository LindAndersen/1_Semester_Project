package com.example.butikui;

class Park extends Space {
    String[] commands = {"exit", "go", "help", "pickup", "reset"};
 
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