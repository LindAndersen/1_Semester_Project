import java.util.Map;


class Centrum extends Space {
    String[] commands = {"exit", "go", "help", "pickup"};
    Trash[] trash = {new Trash("flasker"), new Trash("aviser")};

    Centrum(String name) {
        super(name);
    }

    @Override public void welcome() {
        //Make own welcome for Centrum
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

    public String[] getCommands() {
        return commands;
    }

    public boolean isCommandReachable(String name) {
        return (boolean) super.isCommandReachable(name, commands);
    }

    public void showTrash() {
        super.showTrash(trash);
    }
}