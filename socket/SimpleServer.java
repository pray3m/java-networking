package socket;

// Simple Server Example
import java.net.*;
import java.io.*;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Server will listen on port 8080
        System.out.println("Waiting for client...");
        Socket clientSocket = serverSocket.accept(); // This will wait until a client connects
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Hello, client!");
        serverSocket.close();
    }
}