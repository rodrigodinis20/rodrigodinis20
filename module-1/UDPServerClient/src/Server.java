import javax.sound.midi.Receiver;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

    public static void main(String[] args) {
        int portNumber = 8070;
        new Server().run(portNumber);

    }

        public void run(int port) {
        DatagramSocket serverSocket = null;

        try {
                serverSocket = new DatagramSocket(port);
                byte[] recvBuffer = new byte[1024];
                String sendString = "testing";
                byte[] sendBuffer = sendString.getBytes();
                DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);

                System.out.println("Listening on udp: " + InetAddress.getLocalHost().getHostAddress() + ": " + port);


                while(true) {
                    serverSocket.receive(receivePacket);
                    String message = new String(receivePacket.getData());
                    System.out.println("Received from client: " + message);

                    DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
                    serverSocket.send(sendPacket);

                }
            }
            catch (IOException e) {
                System.out.println(e);;
            }
            finally {
            if (serverSocket != null)
            serverSocket.close();

        }
    }

}

