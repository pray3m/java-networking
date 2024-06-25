import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEncoderDemo {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "This is a URL with special characters &?#/";

        String encodedUrl = URLEncoder.encode(url, "UTF-8");
        System.out.println("Encoded Url : " + encodedUrl);

        String decodedUrl = URLDecoder.decode(encodedUrl);
        System.out.println("Decoded URL : " + decodedUrl);
    }
}
