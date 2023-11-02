class Villakvarter extends Space {
    String[] commands = {"exit", "quit", "bye", "go", "help", "pickup", "reset"};
    Trash[] trash;

    Villakvarter(String name) {
        super(name);
        trash = new Trash[] {new Trash("flasker"), new Trash("aviser")};
        //Add some trash to trash
    }

    public void welcome() {
        //Make own welcome specific for Rækkehuse
        super.welcome();
    }

    public void setRoomTrash(){
        for(Trash t : trash){
            t.setTrash();
        }
    }
    public Trash[] getTrash(){
        return trash;
    }

    @Override
    public void showTrash() {
        super.showTrash(trash);
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