# URL Connections

 The `URLConnection` class represents a connection to a URL and provides methods for interacting with the resource.


**It is a four step process :**
   
1. Construct a URL object.
   ```javav
    URL url = new URL("http://www.example.com");
    ```

2. Open a connection to the URL.
    ```java
     URLConnection connection = url.openConnection();
     ```

3. Get an input stream for reading from the URL.
    ```java
    InputStream in = connection.getInputStream();
    ```

4. Read from the input stream and close the connection.
    ```java
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
    reader.close();
    ```

### Methods of URLConnection class

This class represents a connection to a URL and provides methods for interacting with the resource.

- `public void connect()`: Opens a connection to the URL.

- `public InputStream getInputStream()`: Returns an input stream for reading from the URL.

- `public OutputStream getOutputStream()`: Returns an output stream for writing to the URL.

- `public void setDoInput(boolean doinput)`: Sets whether input is allowed on the connection.

- `public void setDoOutput(boolean dooutput)`: Sets whether output is allowed on the connection.

- `public void setRequestProperty(String key, String value)`: Sets a request property on the connection.

- `public void addRequestProperty(String key, String value)`: Adds a request property to the connection.

- `public void setConnectTimeout(int timeout)`: Sets the connection timeout.

- `public void setReadTimeout(int timeout)`: Sets the read timeout.

- `public void setIfModifiedSince(long ifmodifiedsince)`: Sets the if-modified-since header field.


### Reading the Header

#### i. Retrieving specific header fields

- `public String getContentType()`: Returns the content type of the resource.

- `public int getContentLength()`: Returns the content length of the resource.

- `public int getContentEncoding()`: Returns the content encoding of the resource.

- `public long getDate()`: Returns the date of the resource.

- `public long getExpiration()`: Returns the expiration date of the resource.

- `public long getLastModified()`: Returns the last modified date of the resource.

```java
String contentType = connection.getContentType();
int contentLength = connection.getContentLength();
long date = connection.getDate();
long expiration = connection.getExpiration();
long lastModified = connection.getLastModified();
```
#### ii. Retrieving arbitrary header fields

- `public String getHeaderField(String name)`: Returns the value of the specified header field.

- `public Map<String, List<String>> getHeaderFields()`: Returns a map of the header fields.

- `public String getHeaderFieldKey(int n)`: Returns the key of the header field at the specified index.

```java

// Print all the header fields

try{
    URL url = new URL("http://www.example.com");
    URLConnection connection = url.openConnection();
    for(int i=1;  ;i++){
        String headerFieldKey = connection.getHeaderFieldKey(i);

        if(headerFieldKey == null){
            break;
        }

            System.out.println(headerField + ": " + connection.getHeaderField(headerFieldKey));
 

    }
} catch(Exception e){
    e.printStackTrace();
}
```

## Caches

The `URLConnection` class provides methods for controlling the cache behavior of the connection.

> Pages accessed with `GET` over HTTP can and will be cached by default. The `setUseCaches()` method can be used to disable caching.

> A page accessed with `POST` will not be cached by default.

- `public void setUseCaches(boolean usecaches)`: Sets whether caching is allowed on the connection.

- `public boolean getUseCaches()`: Returns whether caching is allowed on the connection.

- `public void setDefaultUseCaches(boolean defaultusecaches)`: Sets the default value for whether caching is allowed on the connection.

- `public static void setDefaultUseCaches(boolean defaultusecaches)`: Sets the default value for whether caching is allowed on all connections.

- `public static boolean getDefaultUseCaches()`: Returns the default value for whether caching is allowed on all connections.

```java
try{
    URL url = new URL("http://www.example.com");
    URLConnection connection = url.openConnection();
    connection.setUseCaches(false);
    InputStream in = connection.getInputStream();
    // Read from the input stream
    in.close();
} catch(Exception e){
    e.printStackTrace();
}
```

## HttpURLConnection

The `HttpURLConnection` class extends `URLConnection` and provides additional methods for working with HTTP connections.

- `public int getResponseCode()`: Returns the response code of the connection.

- `public String getResponseMessage()`: Returns the response message of the connection.

- `public void setRequestMethod(String method)`: Sets the request method for the connection.

- `public String getRequestMethod()`: Returns the request method for the connection.

- `public void setRequestProperty(String key, String value)`: Sets a request property on the connection.

- `public void addRequestProperty(String key, String value)`: Adds a request property to the connection.

- `public String getRequestProperty(String key)`: Returns the value of the specified request property.

- `public Map<String, List<String>> getRequestProperties()`: Returns a map of the request properties.

## The URLStreamHandler Class

This class is used to create a custom protocol handler for URLs.

- `protected URLConnection openConnection(URL u)`: Opens a connection to the specified URL.

- `protected void parseURL(URL u, String spec, int start, int limit)`: Parses the URL and sets the fields of the URL object.

- `protected boolean sameFile(URL u1, URL u2)`: Compares two URLs to see if they refer to the same file.

- `protected int getDefaultPort()`: Returns the default port for the protocol.

- `protected InetAddress getHostAddress(URL u)`: Returns the IP address of the host.

- `protected boolean hostsEqual(URL u1, URL u2)`: Compares the hosts of two URLs.

- `protected int hashCode(URL u)`: Returns the hash code for the URL.

- `protected boolean equals(URL u1, URL u2)`: Compares two URLs for equality.

- `protected String toExternalForm(URL u)`: Returns the external form of the URL.

- `protected void setURL(URL u, String protocol, String host, int port, String authority, String userInfo, String path, String query, String ref)`: Sets the fields of the URL object.

- `protected void setURL(URL u, String protocol, String host, int port, String file, String ref)`: Sets the fields of the URL object.

- `protected String toExternalForm(URL u)`: Returns the external form of the URL.

- `protected void setURL(URL u, String protocol, String host, int port, String file, String ref)`: Sets the fields of the URL object.
