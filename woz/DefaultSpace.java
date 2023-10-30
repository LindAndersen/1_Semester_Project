import java.util.Map;

interface DefaultSpace {
    void showTrash();
    void subtractTrash(String name, int amount);
    Map<String, Command> getCommands();
}
