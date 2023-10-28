import java.util.Map;

public class Butik extends Space implements DefaultSpace {
    
    Butik(String name) {
        super(name);
    }

    void showUpgrades() {

    }

    void removeUpgrade(String name) {

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
