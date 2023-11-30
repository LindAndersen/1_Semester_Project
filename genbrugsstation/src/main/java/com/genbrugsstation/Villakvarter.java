package com.genbrugsstation;

class Villakvarter extends Space {
    String[] commands = {"exit", "go", "help", "pickup", "reset"};

    Villakvarter(String name) {
        super(name);
    }

    public void welcome() {
        //Make own welcome specific for Rækkehuse
        super.welcome();
    }



    public void showTrash() {

        super.showTrash(super.getTrash());
    }
}