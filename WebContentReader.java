import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebContentReader {
    public static void main(String[] args) {
        String urlString = "https://premdevfolio.vercel.app/";

        try {
            @SuppressWarnings("deprecation")
            URL url = new URL(urlString);

            URLConnection urlConnection = url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            // Read and print the content line by line
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            // Close the BufferedReader
            in.close();

        } catch (MalformedURLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }

    }
}
