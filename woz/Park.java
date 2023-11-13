class Park extends Space {
    static String[] commands = {"exit", "quit", "bye", "go", "help", "pickup"};

    Park(String name) {
        super(name);
        trash = new Trash[] {new Trash("flasker"), new Trash("aviser")};
    }

    public void showTrash() {
        super.showTrash(trash);
    }

    public void welcome() {
        super.welcome();
    }

     public void setRoomTrash(){
        for(Trash t : trash){
            t.setTrash();
        }
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