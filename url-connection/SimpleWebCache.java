import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SimpleWebCache
 *
 * This class demonstrates a simple implementation of a web cache using Java's
 * ResponseCache mechanism. It fetches content from a given URL and caches the
 * response. On subsequent fetches of the same URL, it retrieves the response
 * from the cache if available.
 *
 * Expected output:
 *
 * First fetch:
 * Cache MISS: https://www.example.com
 * Cache PUT: https://www.example.com
 * [Content from the first fetch]
 *
 * Second fetch:
 * Cache HIT: https://www.example.com
 * [Content from the second fetch, should be the same as the first fetch]
 */
public class SimpleWebCache {

    public static void main(String[] args) throws IOException {
        // Set the custom ResponseCache
        ResponseCache.setDefault(new SimpleResponseCache());

        // URL to be fetched
        @SuppressWarnings("deprecation")
        URL url = new URL("https://www.example.com");

        // First fetch
        System.out.println("First fetch:");
        fetchAndPrintContent(url);

        // Second fetch
        System.out.println("\nSecond fetch:");
        fetchAndPrintContent(url);
    }

    /**
     * Fetches content from the given URL and prints it to the console.
     * This method triggers the caching mechanism.
     *
     * @param url The URL to fetch content from.
     * @throws IOException If an I/O error occurs.
     */
    private static void fetchAndPrintContent(URL url) throws IOException {
        URLConnection conn = url.openConnection();
        String cacheControl = conn.getHeaderField("cache-control");
        System.out.println(cacheControl);
        InputStream is = conn.getInputStream();

        // Read data and print
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = is.read(buffer)) != -1) {
            System.out.write(buffer, 0, bytesRead);
        }
        is.close();
    }
}

/**
 * SimpleResponseCache
 *
 * A custom implementation of ResponseCache to handle caching of URL responses.
 */
class SimpleResponseCache extends ResponseCache {
    private final Map<URI, CachedResponse> cache = new HashMap<>();

    @Override
    public CacheResponse get(URI uri, String requestMethod, Map<String, List<String>> requestHeaders) {
        CachedResponse response = cache.get(uri);
        if (response != null) {
            System.out.println("Cache HIT: " + uri);
            return response; // Return cached response
        } else {
            System.out.println("Cache MISS: " + uri);
            return null; // No cached response found
        }
    }

    @Override
    public CacheRequest put(URI uri, URLConnection connection) throws IOException {
        // Ensure we only cache on a miss
        if (!cache.containsKey(uri)) {
            System.out.println("Cache PUT: " + uri);
            SimpleCacheRequest cacheRequest = new SimpleCacheRequest();

            // Read the response
            try (InputStream is = connection.getInputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    cacheRequest.getBody().write(buffer, 0, bytesRead);
                }
            }

            // Cache the response
            CachedResponse cachedResponse = new CachedResponse(connection.getHeaderFields(),
                    cacheRequest.getBodyAsByteArray());
            cache.put(uri, cachedResponse);
            return cacheRequest; // Return the cache request
        }
        return null; // Return null if already cached
    }
}

/**
 * SimpleCacheRequest
 *
 * A custom implementation of CacheRequest to handle the caching of request
 * bodies.
 */
class SimpleCacheRequest extends CacheRequest {
    private final ByteArrayOutputStream body = new ByteArrayOutputStream();

    @Override
    public OutputStream getBody() {
        return body;
    }

    @Override
    public void abort() {
        System.out.println("Cache Request Aborted");
    }

    public byte[] getBodyAsByteArray() {
        return body.toByteArray();
    }
}

/**
 * CachedResponse
 *
 * A custom implementation of CacheResponse to store cached responses.
 */
class CachedResponse extends CacheResponse {
    private final Map<String, List<String>> headers;
    private final byte[] body;

    public CachedResponse(Map<String, List<String>> headers, byte[] body) {
        this.headers = headers;
        this.body = body;
    }

    @Override
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    @Override
    public InputStream getBody() {
        return new ByteArrayInputStream(body);
    }
}
