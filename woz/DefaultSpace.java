//Contains room commands and types of interaction

import java.util.Map;

public interface DefaultSpace {
    void welcome();
    void goodbye();
    Map<String, Integer> getTrash();
    void resetTrash();
    void subtractTrash();
}
