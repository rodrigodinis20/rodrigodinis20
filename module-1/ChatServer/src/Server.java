import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

    }

    int portNumber = 8090;
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
        String messageSent = "";

        System.out.println("Waiting for connections...");
    }
}
