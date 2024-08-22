import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class SearchQueryHandler {

    private static final String SEARCH_API_URL = "https://api.example.com/search?q=";

    public static String performSearch(String userQuery) throws Exception {
        // Encode the user's search query
        String encodedQuery = URLEncoder.encode(userQuery, StandardCharsets.UTF_8.toString());

        // Construct the full URL
        String fullUrl = SEARCH_API_URL + encodedQuery;

        // Create a URL object and open a connection
        URL url = new URL(fullUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set request method
        connection.setRequestMethod("GET");

        // Read the response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Decode the response (assuming it contains the original query)
        String decodedResponse = URLDecoder.decode(response.toString(), StandardCharsets.UTF_8.toString());

        return decodedResponse;
    }

    public static void main(String[] args) {
        try {
            String userQuery = "What's the weather in New York?";
            System.out.println("Original query: " + userQuery);

            String searchResult = performSearch(userQuery);
            System.out.println("Search result: " + searchResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}