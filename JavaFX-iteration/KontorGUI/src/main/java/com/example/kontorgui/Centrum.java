package com.example.kontorgui;

import java.util.Map;
 

class Centrum extends Space {
    String[] commands = {"exit", "go", "help", "pickup", "reset"};

    Centrum(String name) {
        super(name);
    }

    @Override public void welcome() {
        //Make own welcome for Centrum
        super.welcome();
    }


    public String[] getCommands() {
        return commands;
    }

    public boolean isCommandReachable(String name) {
        return (boolean) super.isCommandReachable(name, commands);
    }

    @Override
    public void showTrash() {
        super.showTrash(super.getTrash());
    }
}