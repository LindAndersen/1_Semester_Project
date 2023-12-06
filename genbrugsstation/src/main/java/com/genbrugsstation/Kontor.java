package com.genbrugsstation;


class Kontor extends Space {
    Kontor(String name) {
        super(name);
    }

    void firstDayWelcome() {
        System.out.println("\nVelkommen til kontoret!\n" +
                "Her kan du tjekke din status, inventar, spilletid i dage og de opgraderinger, du har købt til byen.\n" +
                        "Du kan bruge 'status' for at tjekke overstående, og 'help' for at se andre tilgængelige commands i rummet!\n" +
                "God fornøjelse!");
    }
    @Override
    public void welcome() {

    }
}