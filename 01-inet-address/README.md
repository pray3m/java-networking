# Internet Addresses

## IP (Internet Protocol) Address

An IP address is a unique address that identifies a device on the internet or a local network. IP addresses are typically in the format of a 32-bit number, represented as four decimal numbers separated by periods. Each decimal number represents 8 bits of the address.

Java supports two main types of IP addresses:
- IPv4 (32-bit)
- IPv6 (128-bit)

## Domain Names

**Resolved by DNS (Domain Name System) Servers**

Domain names are human-readable names that correspond to the IP addresses of devices on the internet. Domain names are used in URLs to identify particular Web pages. 

For example, in the URL `http://www.example.com/index.html`, the domain name is `example.com`.


## The InetAddress Class

The `InetAddress` class in Java represents an Internet Protocol (IP) address. It encapsulates both the hostname and IP address of a network interface.



### Creating new InetAddress objects
- No public constructors
- Use static factory methods directly
- Automatically connect to DNS server to resolve the host name
> *@returns  `InetAddress` object representing the IP address*

> *@throws `UnknownHostException` if the host name cannot be resolved*

### Methods
- `InetAddress.getByName(String host)` : lookup the name and the numeric address of the host

- `InetAddress.getAllByName(String host)` : lookup all the IP addresses of the host 

- `InetAddress.getLocalHost()` : get the IP address of the local host

- `InetAddress.getLoopbackAddress()` : get the loopback address ***i.e. localhost/127.0.0.1***

- `InetAddress.getByAddress(String host, byte[] addr)` : create InetAddress based on host and address

- `InetAddress.getByAddress(byte[] addr)` : create an InetAddress based on the raw IP address



#### Example
```java
    InetAddress address = InetAddress.getByName("www.tu.edu.np");
```

### Getter Methods

- public string GetHostName();
- public string 











