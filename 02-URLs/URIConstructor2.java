import java.net.URI;
import java.net.URISyntaxException;

public class URIConstructor2 {
    public static void main(String[] args) {
        String scheme = "https";
        String ssp = "github.com/bard";
        String fragment = "issues/123";

        try {
            URI uri = new URI(scheme, ssp, fragment);
            System.out.println("URI : " + uri.toString());

            String host = uri.getHost();
            System.out.println("Host: " + host);

            String path = uri.getPath();
            System.out.println("Decoded Path: " + path);

        } catch (URISyntaxException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }
}
