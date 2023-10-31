class Genbrugsstation extends Space {
    Trash[] trash = {new Trash("metalskrot"), new Trash("batterier"), new Trash("plastik")};
    String[] commands = {"exit", "quit", "bye", "go", "help", "pickup", "recycle"};

    Genbrugsstation(String name) {
        super(name);
    }

    void firstDayWelcome() {
        System.out.println("Velkommen til genbrugsstationen!");
        System.out.println("Her kan du få genanvendt skraldet, du får samlet op, og vekslet dem til XP og mønter! Win win!");
        System.out.println("Mønter får du brug for i butikken.");
    }

    @Override public void welcome() {
        //Make our own welcome for Genbrugstation
        super.welcome();
    }

    @Override public void showTrash() {
        super.showTrash(trash);
    }

    @Override public boolean subtractTrash(String name, int amount) {
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