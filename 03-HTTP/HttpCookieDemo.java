package http;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpCookieDemo {

    private static CookieManager cookieManager = new CookieManager();

    public static void main(String[] args) throws IOException {
        CookieHandler.setDefault(cookieManager);

        @SuppressWarnings("deprecation")
        URL url = new URL("https://google.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        Map<String, List<String>> headerFields = connection.getHeaderFields();

        for (Map.Entry<String, List<String>> headerField : headerFields.entrySet()) {

            if (headerField.getKey() != null) {
                for (String headerValue : headerField.getValue()) {
                    setCookie(headerField.getKey(), headerValue);
                }
            }
        }

        connection.disconnect();

        readCookie();

    }

    public static void setCookie(String key, String value) {
        HttpCookie cookie = new HttpCookie(key, value);
        System.out.println("Cookie set ==> " + cookie);
    }

    public static void readCookie() {
        CookieStore cookieStore = cookieManager.getCookieStore();
        List<HttpCookie> cookies = cookieStore.getCookies();

        for (HttpCookie httpCookie : cookies) {
            System.out.println(httpCookie);
        }

    }

}
