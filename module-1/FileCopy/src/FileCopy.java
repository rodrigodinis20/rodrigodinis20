import java.io.*;

public class FileCopy {

    private FileInputStream in = null;
    private FileOutputStream out = null;

    public static void main(String[] args) throws IOException {

        if(args.length != 2) {
            System.err.println();
            System.exit(1);

        }

        FileCopy fileCopy = new FileCopy();
        fileCopy.start(args[0], args[1]);

    }

    private void start(String src, String dst) {
        byte[] buffer = new byte[1024];

        try {
        in = new FileInputStream("/FileCopy/src/test");
        out = new FileOutputStream(dst);

        int bytesRead = in.read(buffer);

        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);

        }

        } catch (IOException exception) {
            System.err.println(exception.getMessage());
            System.exit(1);

        } finally {
            cleanUp();
        }
    }

    private void cleanUp() {

    }
}
