import java.net.URI;
import java.net.URISyntaxException;

public class URIConstructor3 {
    public static void main(String[] args) {
        String scheme = "https";
        String host = "github.com";
        String ssp = host + "/" + "bard/issues/123"; // Combine host and path
        String fragment = "issues/123";

        try {
            URI uri = new URI(scheme, ssp, fragment);
            System.out.println("URI : " + uri.toString());

            String hostFromUri = uri.getHost(); // Get host from the constructed URI
            System.out.println("Host (from URI): " + hostFromUri);

            String path = uri.getPath();
            System.out.println("Decoded Path: " + path);

        } catch (URISyntaxException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }
}
