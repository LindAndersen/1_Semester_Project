import java.util.Map;
import java.util.HashMap;

class Inventory {
    private Map<String, Integer> items = new HashMap<String, Integer>();

    public Inventory(){
        items = new HashMap<String, Integer>();
    }

    void addItem() {

    }

    void removeItem() {

    }

    public int getItemAmount(String name) {
        return items.get(name);
    }

    public int getTotalAmount() {
        int n = 0;
        for (String name : items.keySet()) {
            n += getItemAmount(name);
        }

        return n;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "";
    }
}