import java.util.Map;
import java.util.HashMap;

class Rækkehuse extends Space {
    Map<String, Trash> trash = new HashMap<String, Trash>();

    Rækkehuse(String name) {
        super(name);
        //Add some trash to trash
    }

    @Override public void welcome() {
        //Make own welcome specific for Rækkehuse
        super.welcome();
    }
}