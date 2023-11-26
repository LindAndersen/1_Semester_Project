package com.genbrugsstation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.File;

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
                boolean didCreateSaves = new File("saves").mkdirs();
                new File("saves\\" + filename).mkdirs();
                System.out.println((didCreateSaves ? "Creating save folder" : ""));
                String pathToSaves = System.getProperty("user.dir") + "\\saves";
                System.out.printf("Will be stored at: %n%s%n", pathToSaves);
                FileOutputStream worldFile = new FileOutputStream(pathToSaves + "\\" + filename + "\\world.ser");
                FileOutputStream contextFile = new FileOutputStream(pathToSaves + "\\" + filename + "\\context.ser");
                ObjectOutputStream worldOut = new ObjectOutputStream(worldFile);
                ObjectOutputStream contextOut = new ObjectOutputStream(contextFile);

                worldOut.writeObject(world);
                contextOut.writeObject(context);
                worldOut.close();
                contextOut.close();
                worldFile.close();
                contextFile.close();

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
