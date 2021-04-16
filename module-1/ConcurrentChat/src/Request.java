import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Request implements Runnable {

    private Server server;
    private Socket socket;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private String hostName;


    public Request(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    public void processRequest(Server server) {

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Please insert username: ");
            hostName = in.readLine();
            setHostName(hostName);
            System.out.println(hostName + " connected to the server.");
            String messageReceived;
            server.broadcast(hostName + " has joined the chat." + "\n");

            while ((messageReceived = in.readLine()) != null) {
                System.out.println("Received from " + hostName + " : " + messageReceived);


                String[] line = messageReceived.split(" ");

                if (line[0].equals("/name")) {
                    server.broadcast(hostName + " changed his name to " + line[1] + "\n");
                    setHostName(line[1]);
                    continue;

                }

                if (messageReceived.equals("/quit")) {
                    server.broadcast(hostName + " has left the chat." + "\n");
                    socket.close();
                    continue;
                }

                if (messageReceived.equals("/users")) {
                    out.print(server.users());
                    out.flush();
                    continue;

                }

                server.broadcast("<" + hostName + "> : " + messageReceived + "\n");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void send(String message) {
        out.print(message);
        out.flush();

    }
    @Override
    public void run() {
        processRequest(server);

    }
}
