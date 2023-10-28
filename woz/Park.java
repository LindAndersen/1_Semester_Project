import java.util.Map;

class Park extends Space implements DefaultSpace {
    Park(String name) {
        super(name);
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