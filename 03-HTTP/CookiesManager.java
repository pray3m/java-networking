import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;

package 03-HTTP;

public class CookiesManager {
    public static void main(String[] args) {
        CookieManager cookieManager = new CookieManager();
        CookieStore store = cookieManager.getCookieStore();

        // creating cookie and uri
        HttpCookie c1 = new HttpCookie("user1", "1");
        HttpCookie c2 = new HttpCookie("user2", "2");

        URI uri1 = URI.create("htttp://spm.com.np");
        URI uri2 = URI.create("htttp://spm.com.np");


        // add
        store.add(uri1, c1);
        store.add(uri2, c2);


        List<HttpCookie> cookiesList = store.getCookies();

        // remove
        store.remove(uri1,c1);

        //remove all
        store.removeAll();
    }
}
