# URLs and URIs

## The Real Difference : URIs vs URLs vs URNs

> **All URLs are URIs, but not all URIs are URLs.**

![URI Types and Subtypes](https://media.beehiiv.com/cdn-cgi/image/fit%3Dscale-down%2Cformat%3Dauto%2Conerror%3Dredirect%2Cquality%3D80/uploads/asset/file/68ca2654-8f07-48e6-855e-88a9e4c9f906/URL-URI-Miessler-2022.png)

- **A `Uniform Resource Identifier (URI)`** is a string of characters that uniquely identify a name or a resource on the internet. A URI identifies a resource by name, location, or both. URIs have two specializations known as Uniform Resource Locator (URL), and Uniform Resource Name (URN).

- **A `Uniform Resource Locator (URL)`** is a type of URI that specifies not only a resource, but how to reach it on the internet—like *http://, ftp://, or mailto://.*

- **A `Uniform Resource Name (URN)`** is a type of URI that uses the specific naming scheme of urn:—like *urn:isbn:0-486-27557-4 or urn:isbn:0-395-36341-1.*

So a URI or URN is like your name, and a URL is a specific subtype of URI that’s like your name combined with your address.


## Structure of a URL

![URL structure](https://media.beehiiv.com/cdn-cgi/image/fit%3Dscale-down%2Cformat%3Dauto%2Conerror%3Dredirect%2Cquality%3D80/uploads/asset/file/eed0f6bf-2e78-4859-bbfe-18cd2efc3f7e/uri-breakdown-2022-1024x135.png)

- `The Scheme`, which is the protocol that you’re using to interact. e.g. *HTTP, HTTPS, FTP, MAILTO, IRC, FILE*

- `The Authority`, which is the target you’re accessing. This breaks down into userinfo, host, and port.

- `The Path`, which is the resource you’re requesting on the host.

- `The Query`, which are the parameters being used within the web application.

- `The Fragment`, which is the target to jump to within a given page.

## The URL Class

### Creating new URL objects

> *@returns  `URL` object*

> *@throws `MalformedURLException` if the URL is not properly formatted*


- URL (String url) 
- URL (String protocol, String host, String path)
- URL (String protocol, String host, int port, String path)
- URL (URL baseURL, String relativeURL)

```java
URL url = new URL("http://www.example.com/index.html");
```

### Retrieving Data from a URL

> *@throws `IOException`*

#### - `InputStream openStream()`
*connects to the resource* referenced by the URL, performs any necessary handshaking between client and the server, and re

```java
try {
    String location = "http://lolcats.com/";
    URL url = new URL(location);
    InputStream is = url.openStream();

    BufferReader br = new BufferReader(new InputStreamReader(is));
    String line;
    while((line = br.readLine())!= null) {
        System.out.println(line);
    }

} catch(IOException ex) {
    System.out.println(ex)
}
```

#### - `URLConnection openConnection()`
 *opens a socket* to the specified URL and returns a `URLConnection` object

 ```java
 URL url = new URL(location);
 URLConnectioin conn = url.openConnection();
 InputStream is = conn.getInputStream();
 BufferedReader br = new BufferedReader( new InputStreamReader(is));

String line;
while((line = br.readLine())!= null) {
    System.out.println(line);
}
 ```

#### - `URL Connection openConnection(Proxy proxy)`

#### - `Object getContent()`
 *retrieves the data* referenced by the URL and tried to make it into some type of object

```java
 URL url = new URL(location);

 Object content = url.getContent();
 sout(content.getClass().getName());
 ```


### Getter Methods : 

- `public String getProtocal()`: Returns the protocol of the URL
- `public String getHost()`: Returns the host name of the URL
- `public int getPort()`: Returns the port number of the URL
- `public String getPath()`: Returns the path of the URL
- `public String getQuery()`: Returns the query string of the URL
- `public String getRef()`: Returns the reference of the URL
- `public String getFile()`: Returns the file name of the URL
- `public String getAuthority()`: Returns the authority of the URL
- `public String getDefaultPort()`: Returns the default port of the URL
- `public String getUserInfo()`: Returns the user info of the URL


## The URI Class

### Creating new URI objects

> *@returns  `URI` object*

> *@throws `URISyntaxException` if the URI is not properly formatted*

- URI (String uri)
- URI (String scheme, String schemaSpecificPart, String fragment)
- URI (String scheme, String authority, String path, String query, String fragment)
- URI (String scheme, String host, String path, String fragment)

```java
URI uri = new URI("http://www.example.com/index.html");
```

### Getter Methods :

- `public String getScheme()`: Returns the scheme of the URI
- `public String getAuthority()`: Returns the authority of the URI
- `public String getUserInfo()`: Returns the user info of the URI
- `public String getHost()`: Returns the host name of the URI
- `public int getPort()`: Returns the port number of the URI
- `public String getPath()`: Returns the path of the URI
- `public String getQuery()`: Returns the query string of the URI
- `public String getFragment()`: Returns the fragment of the URI

- **`getRaw<url-part>()`** : Returns the corresponding info of the url part


## The URLEncoder and URLDecoder Classes

> @returns `String` object

> @throws `UnsupportedEncodingException` if the encoding is not supported

These utility classes are used to encode and decode strings for use in URLs, ensuring that special characters are properly handled.

### URLEncoder

#### `public static String encode(String s, String enc)`
 Encodes a string into application/x-www-form-urlencoded format using a specific encoding scheme.

### URLDecoder

 `public static String decode(String s, String enc)`
 Decodes URL-encoded strings back into their original form.

```java

String url = "http://www.example.com/index.html?name=John Doe";

String encodedURL = URLEncoder.encode(url, "UTF-8");

System.out.println(encodedURL); 
// Output : http%3A%2F%2Fwww.example.com%2Findex.html%3Fname%3DJohn+Doe

String decodedURL = URLDecoder.decode(encodedURL, "UTF-8");

System.out.println(decodedURL);

```
 - *Always specify the character encoding (e.g., UTF-8) when using these methods to ensure consistent behavior across different platforms.*
 - *The `encode()` method replaces spaces with '+' and encodes special characters as hex values preceded by '%'.*
- *The `decode()` method reverses this process, converting '+' back to spaces and *'%XX' hex values back to their original characters.*
 - *These classes are particularly useful when working with query parameters in URLs or when handling user input that will be part of a URL.*




