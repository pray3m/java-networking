import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/*
 * This program establishes a connection to a specified URL, retrieves information about the connection,
* and displays the content if it's text-based.
 */

public class ConnectionConfigure {
    public static void main(String[] args) throws IOException {

        @SuppressWarnings("deprecation")
        URL url = new URL("https://www.example.org");
        URLConnection connection = url.openConnection();

        boolean doInput = connection.getDoInput();
        System.out.println("Do get Input : " + doInput);

        // connection.setDoInput(false);

        String contentType = connection.getHeaderField("content-type");
        System.out.println("Content Type : " + contentType);

        InputStream is = connection.getInputStream();
        readTextInputStream(is);

        boolean doOutput = connection.getDoOutput();
        System.out.println("Do output: " + doOutput);

        boolean allowUserInteraction = connection.getAllowUserInteraction();
        System.out.println("Allow user interaction : " + allowUserInteraction);

        boolean useCache = connection.getUseCaches();
        System.out.println("Use cache : " + useCache);

        long ifModifiedSince = connection.getIfModifiedSince();
        System.out.println("If modified since : " + ifModifiedSince);

        System.out.println("Permission : " + connection.getPermission());

    }

    private static void readTextInputStream(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();

        int byteRead;
        while ((byteRead = is.read()) != -1) {
            sb.append((char) byteRead);
        }
        System.out.println("Content : ");
        System.out.println(sb.toString());
    }
}
