package socket;

import java.io.*;
import java.net.*;

public class RedirectorServer {

    public static void main(String[] args) {
        int port = 8080; // Port number for the server
        String redirectUrl = "http://www.example.com"; // URL to redirect to

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Redirector server is listening on port " + port);

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

                        // Send a redirect response
                        writer.println("HTTP/1.1 301 Moved Permanently");
                        writer.println("Location: " + redirectUrl);
                        writer.println("Content-Length: 0");
                        writer.println(); // Blank line to end headers
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
