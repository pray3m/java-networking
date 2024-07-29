package socket;

// Simple Client Example
import java.net.*;
import java.io.*;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6666); // Connect to server on localhost, port 8080

        socket.shutdownOutput();

        System.out.println("Is output shutdown ? "+socket.isOutputShutdown());

        // PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        // out.println("Hello, server!");


        // BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // String messageFromServer = in.readLine();
        // System.out.println("Server says: " + messageFromServer);

        // socket.setSoTimeout(5000);
        // socket.close();
    }
}
