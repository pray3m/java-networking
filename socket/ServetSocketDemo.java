package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServetSocketDemo {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("Waiting for client request...");

            Socket clientSocket = server.accept();
            System.out.println("Client connected : " + clientSocket.getInetAddress());

            // send message to client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello, client!");

            out.println("Hello, client! 2");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String messageFromClient = in.readLine();
            System.out.println("client says: " + messageFromClient);

            // server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
