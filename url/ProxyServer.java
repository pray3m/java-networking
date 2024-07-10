import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;

public class ProxyServer {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws MalformedURLException, IOException {

        SocketAddress inetAddress = new InetSocketAddress("proxy.example.com", 8080);

        Proxy proxy = new Proxy(Proxy.Type.HTTP, inetAddress);

        URL url = new URL("http://java.example.org/");
        URLConnection connection = url.openConnection(proxy);

        System.out.println(proxy);

        System.out.println("Proxy Type: " + proxy.type());

        // Printing Proxy Address
        // using address() method
        System.out.println("Proxy Address: "
                + proxy.address());

        // Printing Proxy Hashcode
        // using hashCode() method
        System.out.println("Proxy HasHCode: "
                + proxy.hashCode());

        // Printing Proxy String representation
        // using toString() method
        System.out.println("Proxy String: "
                + proxy.toString());

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        // Read and print the content
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
    }
}
