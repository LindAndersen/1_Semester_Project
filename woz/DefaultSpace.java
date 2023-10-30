import java.util.Map;

interface DefaultSpace {
    void showTrash();
    boolean subtractTrash(String name, int amount);
    boolean isCommandReachable(String name);
    String[] getCommands();
}
