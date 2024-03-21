package atividade;

import java.io.*;

public class SaveSystem {

    public static void saveEvents(User user) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("events.data"));
            output.writeObject(user);
            output.close();

        } catch (IOException e) {
            System.err.println("Error saving to file" + e.getLocalizedMessage());
        }
    }

    public static boolean loadEvents() {

        User loadUser = null;

        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("events.data"));
            loadUser = (User) input.readObject();
            input.close();
        } catch (IOException e) {
            //System.err.println("Error opening to file");
        } catch (ClassNotFoundException e) {
            //System.err.println("Object is not a User");
        }

        if (loadUser != null) {
            Main.user = loadUser;
            return true;
        } else {
            return false;
        }
    }

    public static void deleteFile() {
        File file = new File("events.data");
       // String path = file.getAbsolutePath();

        if (file.delete()) {
            System.out.println("Application has been reset.");
        } else {
            System.out.println("Failed to delete " + file.getName() + " file");
        }
    }
}

