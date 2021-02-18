import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Scanner reader = new Scanner(System.in);

        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress address = InetAddress.getLocalHost();

        String sentence = reader.nextLine();
        byte[] sendBuffer = sentence.getBytes();
        byte[] rcvBuffer = new byte[1024];

        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, 8070);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(rcvBuffer, rcvBuffer.length);
        clientSocket.receive(receivePacket);
        String message = new String(receivePacket.getData());
        System.out.println("Received from server: " + message);

        clientSocket.close();
    }
}
