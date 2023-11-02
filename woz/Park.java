class Park extends Space {
    String[] commands = {"exit", "go", "help", "pickup", "reset"};
    Trash[] trash;

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

    @Override
    public void setRoomTrash(){
        for(Trash t : trash){
            t.setTrash();
        }
    }
    public Trash[] getTrash(){
        return trash;
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