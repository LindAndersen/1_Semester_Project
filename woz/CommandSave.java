import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CommandSave extends BaseCommand implements Command {
    World world;
    Context context;

    CommandSave(World world, Context context) {
        this.world = world;
        this.context = context;
        this.description = "Save your game";
    }


    @Override
    public void execute(Context context, String command, String[] parameters) {
        if (guardEq(parameters, 1)) {
            System.out.println("Du har brugt kommandoen forkert. Prøv \"save {filnavn}\n");
            return;
        }

        String filename = parameters[0];

        if (isFileNameAvailable(filename)) {
            try {
                String pathToSaves = System.getProperty("user.dir") + "\\saves";
                System.out.printf("Will be stored at: %n%s%n", pathToSaves);
                FileOutputStream file = new FileOutputStream(pathToSaves + "\\" + filename + ".ser");
                ObjectOutputStream out = new ObjectOutputStream(file);

                out.writeObject(world);
                out.writeObject(context);
                out.close();
                file.close();

                System.out.printf("Completed save with name: %s%n", filename);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isFileNameAvailable(String filename) {
        return true;
    }
    
}
