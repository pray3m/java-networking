import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class CookieHandleExample {
    public static void main(String[] args) throws IOException {

        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        cookieManager.setCookiePolicy(java.net.CookiePolicy.ACCEPT_ORIGINAL_SERVER);

        @SuppressWarnings("deprecation")
        URL url = new URL("https://google.com");
        URLConnection connection = url.openConnection();

        connection.getContent();

        CookieStore cookieStore = cookieManager.getCookieStore();
        List<HttpCookie> cookies = cookieStore.getCookies();

        for (HttpCookie httpCookie : cookies) {
            System.out.println("Domain: " + httpCookie.getDomain());
            System.out.println("Max Age: " + httpCookie.getMaxAge());

            httpCookie.setMaxAge(343);
            System.out.println("New Max Age: " + httpCookie.getMaxAge());
            System.out.println();
        }

    }
}
