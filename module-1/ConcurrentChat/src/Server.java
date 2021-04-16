import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    int portNumber;
    ArrayList<Request> arrayList = new ArrayList<>();
    private ServerSocket server;
    private Socket client = null;
    private ExecutorService threadPool = Executors.newFixedThreadPool(15);

    public Server(int portNumber) {
        this.portNumber = portNumber;

        try {

            System.out.println("Awaiting connections on: " + InetAddress.getLocalHost().getHostAddress() + ":" + portNumber);
            server = new ServerSocket(portNumber);

        } catch (IOException ex) {
            System.out.println("ERROR: " + ex);
        }
    }

    public void start() throws IOException {

        while (server.isBound()) {
            client = server.accept();
            Request request = new Request(client, this);
            threadPool.submit(request);
            arrayList.add(request);

        }
    }

    public String users() {

        StringBuilder userList = new StringBuilder();
        userList.append("Connected users: " + "\n");

        for (Request request : arrayList) {
            
            userList.append(request.getHostName() + "\n");

        }
        return userList.toString();
    }

    public void broadcast(String message) throws IOException {

        for(Request request : arrayList) {
            request.send(message);
        }
    }
}
