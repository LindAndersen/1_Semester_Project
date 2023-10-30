import java.util.Map;

interface DefaultSpace {
    void showTrash();
    void subtractTrash(String name, int amount);
    boolean isCommandReachable(String name);
    String[] getCommands();
}
