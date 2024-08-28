package socket;

// Simple Client Example
import java.net.*;
import java.io.*;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080); // Connect to server on localhost, port 8080
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String messageFromServer = in.readLine();
        System.out.println("Server says: " + messageFromServer);
        socket.close();
    }
}
