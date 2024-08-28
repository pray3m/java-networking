

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpHeaders {

    public static void main(String[] args) throws MalformedURLException, IOException {
        // Socket socket = new Socket("www.example.com", 80);
        // socket.setKeepAlive(true);

        @SuppressWarnings("deprecation")
        URL url = new URL("https://www.facebook.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("HEAD");

        // Print all header fields
        Map<String, List<String>> headers = connection.getHeaderFields();

        headers.forEach((key, value) -> System.out.println(key + ": " + String.join(", ", value)));

    }

}
