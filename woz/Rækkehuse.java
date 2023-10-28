import java.util.Map;
import java.util.HashMap;

class Rækkehuse extends Space implements DefaultSpace {
    Map<String, Trash> trash = new HashMap<String, Trash>();

    Rækkehuse(String name) {
        super(name);
        //Add some trash to trash
    }

    @Override public void welcome() {
        //Make own welcome specific for Rækkehuse
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