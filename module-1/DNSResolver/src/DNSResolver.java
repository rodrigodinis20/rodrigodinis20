import java.net.InetAddress;
import java.util.Scanner;

public class DNSResolver {

    public static void main(String[] args) {

        try {
            InetAddress address = InetAddress.getByName(getHost());

            System.out.println(address.isReachable(3000) ? "Testing reachability for " + address.getHostAddress() + " : OK!" :
                    "Testing reachability for " + address.getHostAddress() + " : FAIL!");

        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }

    private static String getHost() {
            Scanner reader = new Scanner(System.in);
            System.out.print("Hostname?");
            return reader.nextLine();
        }
}
