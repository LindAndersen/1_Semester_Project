import java.io.*;
import java.util.*;

class Commandsaveload extends BaseCommand implements Command {
    private final String fileName; // This variable stores the name of the file where we save and read variables.
    private final Map<String, String> variables; // Use a LinkedHashMap to preserve the order

    // Constructor to initialize the class with a file name.
    public Commandsaveload(String fileName) {
        this.fileName = fileName;
        variables = new LinkedHashMap<>();
    }

    // Method to save a variable and its value to the text file.
    public void save(String variableName, String variableValue) {
        // Read existing variables, overwrite the file, and then add the new variable.
        variables.put(variableName, variableValue);

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, false))) {
            for (String key : variables.keySet()) {
                writer.println(key + "=" + variables.get(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read variables from the text file and store them in a map.
    public Map<String, String> load() {
        Map<String, String> variables = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)) ) {
            // Read lines from the file and split them into variable name and value.
            reader.lines().map(line -> line.split("=", 2))
                    .filter(parts -> parts.length == 2)
                    .forEach(parts -> variables.put(parts[0], parts[1]));
        } catch (IOException e) {
            e.printStackTrace();
            // Handle any errors that occur during file reading, such as if the file doesn't exist.
        }

        return variables;
    }

    private Rækkehuse rækkehuseInstance;

    Commandsaveload(Rækkehuse rækkehuseInstance) {
        this.rækkehuseInstance = rækkehuseInstance;
    }

    // Method to set the trash variable in the Rækkehuse instance
    public void setTrashInRækkehuse(Trash[] newTrash) {
        rækkehuseInstance.setTrash(newTrash);
    }

    // Method to get the trash variable as a string from the Rækkehuse instance
    public String getTrashInRækkehuseAsString() {
        return rækkehuseInstance.getTrashAsString();
    }

    @Override
    public void execute (Context context, String command, String[] parameters) {

        Commandsaveload Commandsaveload = new Commandsaveload("variables.txt");

        switch(command) {

            case "save":


                // Save variables
                Commandsaveload.save("player", context.getPlayer());
                Commandsaveload.save("location", context.getCurrent());
                Commandsaveload.save("day count", context.getDay());
                Commandsaveload.save("trash rækkehuse", );
                Commandsaveload.save("trash park", );

                break;

            case "load":
                // Read and print variables
                Map<String, String> savedVariables = Commandsaveload.load();
                savedVariables.forEach((key, value) -> System.out.println(key + " = " + value));
                break;
        }
    }
}
