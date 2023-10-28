import java.util.Map;

class Kontor extends Space implements DefaultSpace {
    Kontor(String name) {
        super(name);
    }

    @Override
    public void welcome() {
        //Specify welcome for Kontor
        super.welcome();
    }

    private void getStatus() {
        //Some status out, informing the player of upgrades, day counter, inventory, and some indicator of how well a player is doing
    }

    @Override
    public Map<String, Integer> getTrash() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTrash'");
    }

    @Override
    public void resetTrash() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetTrash'");
    }

    @Override
    public void subtractTrash() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subtractTrash'");
    }

}