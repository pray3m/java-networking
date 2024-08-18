import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("Localhost: " + address);

            address = InetAddress.getByName("www.baidu.com");
            System.out.println(address);
            System.out.println("Host Address : " + address.getHostAddress());
            System.out.println("Host Name : " + address.getHostName());
            System.out.println("Canonical Hostname: " + address.getCanonicalHostName());

            InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
            for (InetAddress addr : addresses) {
                System.out.println(addr);
            }

            address = InetAddress.getLoopbackAddress();
            System.out.println("Loopback Address: " + address);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
