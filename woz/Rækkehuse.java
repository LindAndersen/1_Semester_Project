class Rækkehuse extends Space {
    String[] commands = {"exit", "quit", "bye", "go", "help", "pickup"};
    Trash[] trash = {new Trash("flasker"), new Trash("aviser")};

    Rækkehuse(String name) {
        super(name);
        //Add some trash to trash
    }

    // Method to convert the trash array to a string
    public String getTrashAsString() {
        StringBuilder trashString = new StringBuilder();
        for (Trash t : trash) {
            trashString.append(t.getName()).append(": ").append(t.getAmount()).append(", ");
        }
        return trashString.toString();
    }

    public void welcome() {
        //Make own welcome specific for Rækkehuse
        super.welcome();
    }

    @Override
    public void showTrash() {
        super.showTrash(trash);
    }

    @Override
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
