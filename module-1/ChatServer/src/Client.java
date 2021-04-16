import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        Client client = new Client(9030);
    }

    int portNumber = 9030;
    private Socket clientSocket;
    private BufferedReader terminalIn;
    private BufferedReader serverIn;
    private PrintWriter out;

    public Client(int portNumber) {

        try {

            System.out.println("Connected to server: " + InetAddress.getLocalHost().getHostAddress() + ": " + portNumber);
            clientSocket = new Socket(InetAddress.getLocalHost().getHostAddress(), portNumber);
            terminalIn = new BufferedReader(new InputStreamReader(System.in));
            serverIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);


            String line = "";
            String message = "";

            while(!line.equals(null)) {
                try{
                    line = terminalIn.readLine();
                    System.out.println("Sent to the server: " + line);
                    out.println(line);
                    message = serverIn.readLine();
                    System.out.println("Received from the server: " + message);

                }
                catch (IOException e){
                    System.out.println(e);
                }
            }
        }
        catch (UnknownHostException e) {
            System.out.println(e);
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }
}
