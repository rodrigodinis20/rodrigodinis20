import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        Server server = new Server(9030);
        server.run();
    }

    int portNumber = 9030;
    private Socket clientSocket;
    private ServerSocket serverSocket;
    private BufferedReader in;
    private PrintWriter out;

    public Server(int portNumber) {
        this.portNumber = portNumber;

        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Server started!");

        }
        catch (IOException e) {
            System.out.println(e);

        }
    }

    public void run() {
        String messageReceived = "";
        //String messageSent = "";

        System.out.println("Waiting for connections...");

        try {
            clientSocket = serverSocket.accept();
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
                System.out.println("Connection successful!");

            while(serverSocket.isBound()) {

                messageReceived = in.readLine();
                System.out.println("Received from client: " + messageReceived);
                out.println(messageReceived.toUpperCase());
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
