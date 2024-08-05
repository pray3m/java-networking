package socket;

import java.io.*;
import java.net.*;

public class SimpleHttpServer {

    public static void main(String[] args) {
        int port = 8080; // Port number for the server

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("New client connected");

                    InputStream input = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);

                    // Read the request
                    String line = reader.readLine();
                    if (line != null) {
                        System.out.println("Request: " + line);

                        // Send a basic HTTP response
                        writer.println("HTTP/1.1 200 OK");
                        writer.println("Content-Type: text/html");
                        writer.println("Content-Length: 13");
                        writer.println(); // Blank line to end headers
                        writer.println("Hello, World!"); // Response body
                    }
                } catch (IOException ex) {
                    System.out.println("Server exception: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
