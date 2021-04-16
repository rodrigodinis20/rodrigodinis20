import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) throws IOException {

        int portNumber = 8080;
        ServerSocket server = new ServerSocket(portNumber);
        Socket client = null;

        while (server.isBound()) {
            client = server.accept();
            HttpRequest request = new HttpRequest(client);
            Thread thread = new Thread(request);
            thread.start();

        }
    }

    /*private int portNumber = 8080;
    private Socket clientSocket;
    private ServerSocket serverSocket;
    private BufferedReader in;
    private DataOutputStream out;

    public Server() {
        //this.clientSocket = clientSocket;

        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Server has been started.");

        }
        catch (IOException ex) {
            System.out.println("ERROR: " + ex);
        }
    }

    public void runServer() {

        System.out.println("Waiting for connections...");

        try {

            String messageReceived = "";
            clientSocket = serverSocket.accept();
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new DataOutputStream(clientSocket.getOutputStream());

            while(serverSocket.isBound()) {
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
                out.close();
                in.close();
                clientSocket.close();
                restart();

            }

        } catch (IOException ex) {
            System.out.println("ERROR: " + ex);
        }
    }

    public void restart() {
        try {

            clientSocket = serverSocket.accept();
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new DataOutputStream(clientSocket.getOutputStream());

            
        }
    catch (IOException ex) {
        System.out.println("ERROR: " + ex);
        }
    }

     */
}

