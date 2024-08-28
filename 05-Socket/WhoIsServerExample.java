package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class WhoIsServerExample {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("whois.markmonitor.com");
        int port = 43;

        String domain = "google.com";

        WhoIsServer whoIs = new WhoIsServer(address, port);
        String domainDetails = whoIs.query(domain);
        System.out.println("Domain details: " + domainDetails);

    }
}

class WhoIsServer {
    private int port;
    private InetAddress address;

    public WhoIsServer(InetAddress address, int port) {
        this.address = address;
        this.port = port;
    }

    public String query(String domain) {
        StringBuilder sb = new StringBuilder();
        try (
                Socket socket = new Socket(address, port);

                OutputStream out = socket.getOutputStream();

                BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        ) {
          
            out.write((domain + "\r\n").getBytes()); //  carriage return
            out.flush();

            String line;

            while ((line = buffer.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}