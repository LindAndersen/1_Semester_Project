class Genbrugsstation extends Space {
    Trash[] trash = {new Trash("metalskrot"), new Trash("batterier"), new Trash("plastik")};
    String[] commands = {"exit", "quit", "bye", "go", "help", "pickup", "recycle", "reset"};

    Genbrugsstation(String name) {
        super(name);
    }

    @Override public void showTrash() {
        super.showTrash(trash);
    }

    public void setRoomTrash(){
        for(Trash t : trash){
            t.setTrash();
        }
    }
    public Trash[] getTrash(){
        return trash;
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