package socket;

// Simple Client Example
import java.net.*;
import java.io.*;

public class ClientSocketDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6666); // Connect to server on localhost, port 8080

        socket.shutdownOutput();
        boolean noDelay = socket.getTcpNoDelay();
        System.out.println("Is TCP No Delay ? " + noDelay);

        socket.setTcpNoDelay(true);
        noDelay = socket.getTcpNoDelay();
        System.out.println("Is TCP No Delay  (after setting true) ? " + noDelay);

        socket.setSoLinger(noDelay, 0);

        System.out.println("Is output shutdown ? " + socket.isOutputShutdown());

        // PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        // out.println("Hello, server!");

        // BufferedReader in = new BufferedReader(new
        // InputStreamReader(socket.getInputStream()));
        // String messageFromServer = in.readLine();
        // System.out.println("Server says: " + messageFromServer);

        socket.setReuseAddress(noDelay);

        socket.setOOBInline(noDelay);
        socket.setTrafficClass(0);

        socket.setSoTimeout(2000);
        System.out.println("Closing socket in 2 seconds...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
