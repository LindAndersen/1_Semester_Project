package com.genbrugsstation;

class Genbrugsstation extends Space {
    Trash[] trash;
 
    Genbrugsstation(String name) {
        super(name);
        trash = new Trash[] {new Trash("metalskrot"), new Trash("batterier"), new Trash("plastik")};
    }

    void firstDayWelcome() {
        System.out.println("\nVelkommen til genbrugsstationen!\n" +
                "Her kan du få genanvendt skraldet, du får samlet op, og vekslet dem til XP og mønter! Win win!\n" +
                "Mønter får du brug for i butikken.\n" + "Du kan bruge 'recycle' for at genbruge skraldet, og 'help' for at se andre tilgængelige commands i rummet!");
    }

    public Trash[] getTrash(){
        return trash;
    }

//    @Override
//    public boolean isCommandReachable(String name) {
//        return super.isCommandReachable(name, commands);
//    }
//
//    @Override
//    public String[] getCommands() {
//        return commands;
//    }
}