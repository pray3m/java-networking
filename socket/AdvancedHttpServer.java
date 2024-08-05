package socket;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class AdvancedHttpServer {

    public static void main(String[] args) {
        final int port = 8080; // Port to listen on
        ExecutorService threadPool = Executors.newFixedThreadPool(10); // Thread pool for handling multiple clients

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("HTTP Server is listening on port " + port);

            while (true) {
                try {
                    final Socket socket = serverSocket.accept();
                    threadPool.execute(() -> handleRequest(socket));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String requestLine = in.readLine();
            if (requestLine != null && requestLine.startsWith("GET")) {
                System.out.println("Request: " + requestLine);

                // Simple routing example
                String responseBody;
                if (requestLine.contains("/hello")) {
                    responseBody = "<html><body><h1>Hello, World!</h1></body></html>";
                } else {
                    responseBody = "<html><body><h1>404 Not Found</h1></body></html>";
                }

                // Construct the HTTP response
                String responseHeaders = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: " + responseBody.length() + "\r\n" +
                        "\r\n";

                out.print(responseHeaders);
                out.print(responseBody);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}