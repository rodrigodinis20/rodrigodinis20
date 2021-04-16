import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpRequest implements Runnable {

    Socket clientSocket;

    public HttpRequest(Socket clientSocket) {
        this.clientSocket = clientSocket;

    }

    public void processRequest() {
        try {

            String messageReceived = "";
            BufferedReader in = null;
            DataOutputStream out = null;
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new DataOutputStream(clientSocket.getOutputStream());

                System.out.println("Connection successful!");
                messageReceived = in.readLine();
                System.out.println("Received from client: " + messageReceived);

                if(messageReceived.split(" ")[1].equals("/")){
                    String header =
                            "HTTP/1.0 200 Document Follows\r\n" +
                                    "Content-Type: text/html; charset=UTF-8\r\n" +
                                    "Content-Length: <file_byte_size> \r\n" +
                                    "\r\n";

                    out.writeBytes(header);
                    out.write(Files.readAllBytes(Path.of("resources/index.html")));

                }
                else if (messageReceived.split(" ")[1].equals("/favicon.ico")) {
                    String header ="HTTP/1.0 200 Document Follows\r\n" +
                            "Content-Type: image/<image_file_extension> \r\n" +
                            "Content-Length: <file_byte_size> \r\n" +
                            "\r\n";

                    out.writeBytes(header);
                    out.write(Files.readAllBytes(Path.of("resources/favicon.jpg")));

                }
                else {
                    String header = "HTTP/1.0 404 Not Found\r\n" +
                            "Content-Type: text/html; charset=UTF-8\r\n" +
                            "Content-Length: <file_byte_size> \r\n" +
                            "\r\n";

                    out.writeBytes(header);
                    out.write(Files.readAllBytes(Path.of("resources/error.html")));
                }

                clientSocket.close();



        } catch (IOException ex) {
            System.out.println("ERROR: " + ex);
        }
    }

    @Override
    public void run() {
        processRequest();
    }
}
