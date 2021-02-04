import java.io.File;
import java.io.FileNotFoundException;

public class FileManager {

    private boolean loggedIn = false;
    private int fileCounter = 0;
    private File[] files;


    public FileManager(int maxFiles) {
        files = new File[maxFiles];

    }

    public void login() {
        loggedIn = true;

    }

    public void logout() {
        loggedIn = false;

    }

    public File getFile(String name) throws FileNotFoundException {
        for (File file : files) {
            if (file.getName().equals(name)) {
                return file;
                //System.out.println("you found a file");

            }

        }
        throw new FileNotFoundException();

    }



    public void createFile(String name) throws NotEnoughPermissionsException, NotEnoughSpaceException {
        if(!loggedIn) {
            throw new NotEnoughPermissionsException();
        }

        if (fileCounter == files.length) {
            throw new NotEnoughSpaceException();
        }

        files[fileCounter] = new File(name);
        fileCounter++;

        /*for (int i = 0; i < files.length; i++) {

            if (files[i] == null) {
                files[i] = new File(name);
                System.out.println("You create a new file named: " + name);
                return;

            }
        }


         */

    }
}