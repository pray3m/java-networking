# Sockets in Java : Client-Side

A socket is a connection between two hosts. 

Sockets provide a way for clients and servers to communicate over a network. In Java, the `Socket` class represents the client-side endpoint of a two-way communication link between a client and a server.

#### Key Concepts:
- **Client-Server Communication**: A client socket connects to a server socket to exchange data.
- **TCP Connection**: Sockets use the TCP protocol, ensuring reliable, ordered, and error-checked data transmission.
- **Blocking Operations**: Socket operations like reading from or writing to a socket are blocking by default, meaning the program waits for the operation to complete.

## Socket Class

The `Socket` class in Java represents a **client-side socket** that connects to a server socket. It provides methods to send and receive data over the network.

## Constructors

### Basic Constructors

#### 1. Socket(String host, int port) throws Unknown Host Exception, IOException

```java
Socket socket = new Socket("localhost", 8080);
```

#### 2. Socket(InetAddress address, int port) throws IOException

```java
InetAddress address = InetAddress.getByName("localhost");
Socket socket = new Socket(address, 8080);
```
#### 3. Socket(String host, int port, InetAddress localAddr, int localPort) throws UnknownHostException, IOException

```java
Socket socket = new Socket("localhost", 8080, InetAddress.getLocalHost(), 0);
```
#### 4. Socket(InetAddress address, int port, InetAddress localAddr, int localPort) throws IOException

```java
InetAddress address = InetAddress.getByName("localhost");
Socket socket = new Socket(address, 8080, InetAddress.getLocalHost(), 0);
```

### Proxy Constructors

This constructor is used to create a socket that connects through a specified proxy server.

#### 1. Socket(Proxy proxy) throws IOException

```java
Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.example.com", 8080));

Socket socket = new Socket(proxy);
```

#### 2. Socket(Proxy proxy, SocketAddress address) throws IOException

```java
SocketAddress proxyAddress = new InetSocketAddress("proxy.example.com", 8080);

Proxy proxy = new Proxy(Proxy.Type.HTTP, proxyAddress);

SocketAddress remote = new InetSocketAddress("example.com", 80);

Socket socket = new Socket(proxy, serverAddress);

socket.connect(remote);

```

### Constructing without Connecting

In some cases, you might want to create a socket without immediately connecting to a server. This approach gives you the flexibility to configure the socket before establishing the connection.

```java
Socket socket = new Socket();

socket.connect(new InetSocketAddress("example.com", 80));
```


## Getting Socket Information

- `InetAddress getInetAddress()`: Returns the remote IP address to which the socket is connected.
- `int getPort()`: Returns the remote port to which the socket is connected.
- `InetAddress getLocalAddress()`: Returns the local IP address to which the socket is bound.
- `int getLocalPort()`: Returns the local port to which the socket is bound.


## Sending and Receiving Data

### Creating a Client Socket

To create a client socket, you typically connect to a server's IP address and port.

```java
Socket socket = new Socket("server_ip", server_port);
```

### Common Operations

1. **Connecting to a Server**
    ```java
    Socket socket = new Socket("localhost", 8080);
    ```
   - Connects to a server running on `localhost` at port `8080`.

2. **Sending Data to the Server**
    ```java
    OutputStream output = socket.getOutputStream();
    PrintWriter writer = new PrintWriter(output, true);
    writer.println("Hello, Server!");
    ```
   - Sends a message to the server.

3. **Receiving Data from the Server**
    ```java
    InputStream input = socket.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
    String response = reader.readLine();
    System.out.println("Server response: " + response);
    ```
   - Receives and prints the server's response.

4. **Closing the Connection**
    ```java
    socket.close();
    ```
   - Closes the socket and releases resources.

### Example: Simple Client

a simple client that connects to a server, sends a message, and prints the response.

```java
import java.io.*;
import java.net.Socket;

public class SimpleClient {

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 8080;

        try (Socket socket = new Socket(serverAddress, serverPort);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send a message to the server
            writer.println("Hello, Server!");

            // Read the server's response
            String response = reader.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Key Points:
- **Socket Initialization**: The client socket is initialized with the server’s address and port.
- **I/O Streams**: `OutputStream` is used for sending data, and `InputStream` is used for receiving data.
- **Exception Handling**: Sockets can throw `IOException`, so proper exception handling is necessary.
- **Resource Management**: Always close the socket after communication is done to free resources.


## Socket Options

Socket options specify how the native sockets on whicho the Java Socket class relies send and receive data. These options can be set using the `setOption()` method.

> Follow classic Unix C naming conventions


### TCP_NODELAY
Packets are sent as quickly as possible regardless of their size (even 1 byte)

   ```java 
  public void setTcpNoDelay(boolean on) throws SocketException

// setTcpNoDelay(true) turns off buffering for the socket

  public boolean getTcpNoDelay throws SocketException
  ```

### SO_TIMEOUT
Sets a timeout for blocking operations, such as reading from the socket. If the timeout is reached and no data has been received, a `SocketTimeoutException` is thrown.

```java
public void setSoTimeout(int timeout) throws SocketException

// Set a timeout of 5000 milliseconds (5 seconds)
socket.setSoTimeout(5000);

public int getSoTimeout() throws SocketException
```
This method returns the current timeout value in milliseconds.

### SO_LINGER
Specifies how long the socket should wait to send remaining data when the socket is closed. The linger time can be set to ensure that data is not lost if the socket is closed abruptly.

```java
public void setSoLinger(boolean on, int linger) throws SocketException

// setSoLinger(true, 10) sets the linger time to 10 seconds
socket.setSoLinger(true, 10);

public int getSoLinger() throws SocketException
```
Returns the linger time in seconds. A return value of `-1` indicates that lingering is disabled.

### SO_KEEPALIVE
Enables the sending of keep-alive messages on the connection. This is useful for detecting dead peers in a long-lived connection.

If turned on, the client occassionally sends a data packet over an idle connection to make sure the server hasn't crashed. Default is false.

```java
public void setKeepAlive(boolean on) throws SocketException

// setKeepAlive(true) enables keep-alive messages
socket.setKeepAlive(true);

public boolean getKeepAlive() throws SocketException
```
Returns whether the keep-alive option is enabled.

### SO_REUSEADDR
Allows a socket to bind to a port that is already in use, which can be useful when restarting a server application or running multiple instances on the same machine.

```java
public void setReuseAddress(boolean on) throws SocketException

// setReuseAddress(true) allows the reuse of a local address
socket.setReuseAddress(true);

public boolean getReuseAddress() throws SocketException
```
Returns whether the `SO_REUSEADDR` option is enabled.

### SO_RCVBUF
Sets the receive buffer size for the socket, which affects how much data can be buffered when receiving data from the network.

```java
public void setReceiveBufferSize(int size) throws SocketException

// setReceiveBufferSize(8192) sets the receive buffer size to 8 KB
socket.setReceiveBufferSize(8192);

public int getReceiveBufferSize() throws SocketException
```
Returns the current size of the receive buffer in bytes.

### SO_SNDBUF
Sets the send buffer size for the socket, which affects how much data can be buffered when sending data over the network.

```java
public void setSendBufferSize(int size) throws SocketException

// setSendBufferSize(8192) sets the send buffer size to 8 KB
socket.setSendBufferSize(8192);

public int getSendBufferSize() throws SocketException
```
Returns the current size of the send buffer in bytes.

### SO_OOBINLINE
The SO_OOBINLINE option controls how Out-of-Band (OOB) data is handled in a socket. Out-of-Band data is a special type of data that can be sent alongside normal data but is treated with higher priority. In the context of TCP/IP, OOB data is often used for urgent messages.

```java
socket.setOOBInline(true); 
// Enables inline processing of OOB data

boolean isOOBInline = socket.getOOBInline(); 
// Checks if OOBInline is enabled

public void sendUrgentData(int data) throws IOException;
```

### IP_TOS
Sets the Type of Service (TOS) or traffic class field in the IP header for packets sent by the socket. This option is used to specify the priority and quality of service for the network traffic.

```java
public void setTrafficClass(int tc) throws SocketException

// setTrafficClass(0x10) sets the TOS field to a specific value
socket.setTrafficClass(0x10);

public int getTrafficClass() throws SocketException
```
Returns the current value of the TOS field.

These options allow developers to fine-tune socket behavior according to their application's needs, providing control over performance, reliability, and data transmission characteristics.
