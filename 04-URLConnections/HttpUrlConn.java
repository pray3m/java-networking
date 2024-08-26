import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConn {
    public static void main(String[] args) throws IOException {

        @SuppressWarnings("deprecation")
        URL url = new URL("https://www.example.org");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        String responseMessage = connection.getResponseMessage();

        System.out.println("Status : " + responseCode + " " + responseMessage);
    }
}
