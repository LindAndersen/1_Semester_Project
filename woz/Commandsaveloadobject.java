import java.io.*;

public class Commandsaveloadobject {

    // Method to save an object to a file
    public static void saveObjectToFile(Object obj, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(obj);
            System.out.println("Object saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load an object from a file
    public static Object loadObjectFromFile(String filePath) {
        Object obj = null;
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            obj = objectIn.readObject();
            System.out.println("Object loaded from " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void execute (Context context, String command, String[] parameters) {
        // Example of saving and loading an object
        // Replace 'YourObject' with the class of the object you want to save/load.
        YourObject objectToSave = new YourObject("Example Data");

        switch(command) {

            case "save":
                // Save the object to a file
                Commandsaveloadobject.saveObjectToFile(objectToSave, "objectData.ser");

                break;

            case "load":
                // Load the object from the file
                YourObject loadedObject = (YourObject) Commandsaveloadobject.loadObjectFromFile("objectData.ser");

                // Verify the loaded object
                if (loadedObject != null) {
                System.out.println("Loaded Data: " + loadedObject.getData());

                break;

        }
    }
}
