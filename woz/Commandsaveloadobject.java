import java.io.*;

public class Commandsaveloadobject extends BaseCommand implements Command {

    // Method to save objects to a file
    public static void saveObjectsToFile(Object[] objects, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(objects);
            System.out.println("Objects saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load objects from a file
    public static Object[] loadObjectsFromFile(String filePath) {
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Object[] objects = (Object[]) objectIn.readObject();
            System.out.println("Objects loaded from " + filePath);
            return objects;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Object[0]; // Return an empty array or handle the error as appropriate
        }
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        // Example of saving and loading objects initialized in the World class
        World worldToSave = new World();

        switch (command) {

            case "save":
                // Save the objects to a file
                Object[] objectsToSave = worldToSave.getLocations();
                Commandsaveloadobject.saveObjectsToFile(objectsToSave, "worldObjects.ser");


            case "load":
                // Load the objects from the file
                Object[] loadedObjects = Commandsaveloadobject.loadObjectsFromFile("worldObjects.ser");

                // Verify the loaded objects
                for (Object obj : loadedObjects) {
                    if (obj instanceof Space) {
                        System.out.println("Loaded Space: " + ((Space) obj).getName());
                    }
                    // Add checks for other object types as needed
                }
        }
    }
}

