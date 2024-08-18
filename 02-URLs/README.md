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
