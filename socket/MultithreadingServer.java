package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadingServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;

        try {

            server = new ServerSocket(8080);
            System.out.println("Waiting for client");

            // Client filename : ClientThread.java

            Socket clientSocket = server.accept();

            server.setReuseAddress(false);

            Thread thread = new ClientHandler(clientSocket);
            thread.start();

        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        } finally {
            server.close();
        }

    }

}

class ClientHandler extends Thread {

    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                writer.println("Hello Client from server !");
            }

        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
}