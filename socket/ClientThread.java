package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println("Hello Server !");

        String messageFromServer = in.readLine();
        System.out.println("Server says: " + messageFromServer);

        socket.close();
    }
}
