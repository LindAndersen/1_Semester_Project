import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

class Inventory implements Serializable {
    Map<String, Integer> items = new HashMap<String, Integer>();

    public Inventory(){
        items = new HashMap<String, Integer>();
    }

    void addItem() {

    }

    void removeItem() {

    }

    int getItemAmount() {
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }
}