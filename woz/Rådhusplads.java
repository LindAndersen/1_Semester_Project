import java.util.Map;

class Rådhusplads extends Space implements DefaultSpace {
    Rådhusplads(String name) {
        super(name);
    }

    @Override public void welcome() {
        //Make own welcome for Rådshusplads
        super.welcome();
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