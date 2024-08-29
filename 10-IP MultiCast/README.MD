###  Multicast Socket
A MulticastSocket is a datagram socket that is convenient for sending and receiving IP multicast datagrams. The MulticastSocket constructors create a socket with appropriate socket options enabled that make it suitable for receiving multicast datagrams.

![IP MultiCast Architecture](/public/multicastjpg.jpg)

### 1.Multicast Addresses and Groups

- **Multicast Groups**:A multicast group is essentially a set of receivers that are interested in a particular stream of data. Each group is identified by a unique multicast address.

-A set of devices that have joined a multicast address to receive data sent to that address.

### 2.Examples of Multicast Groups in Use
- **Streaming Media**: A server streaming a live event might use a multicast address like 224.1.1.1. All clients who want to watch the event would join the multicast group for 224.1.1.1, and the server sends the video stream to this address. The network then efficiently distributes the stream to all members of the group.

### 3.Multicast Addresses
- **IPv4 Multicast Addresses**:Multicast addresses in IPv4 are defined in the range from 224.0.0.0 to 239.255.255.255. These addresses are reserved for multicast traffic and are not used for regular unicast communication.      

### 4.Clients and Servers

A socket is a simple communication channel through which two programs communicate over a network. A socket supports two-way communication between a client and a server, using a well-established protocol. The protocol simply prescribes rules and behavior that both the server and client must follow in order to establish two-way communication.
According to this protocol, a server program creates a socket at a certain port and waits until a client requests a connection. A port is a particular address or entry point on the host computer, which typically has hundreds of potential ports. It is usually represented as a simple integer value. For example, the standard port for an HTTP (Web) server is 80. Once the connection is established, the server creates input and output streams to the socket and begins sending messages to and receiving messages from the client. Either the client or the server can close the connection, but it’s usually done by the client.

### 5.Routers and Routing

A Router is a process of selecting path along which the data can be transferred from source to the destination. Routing is performed by a special device known as a router.

The routing algorithms are used for routing the packets. The routing algorithm is nothing but a software responsible for deciding the optimal path through which packet can be transmitted.

![With and Without Multicast Sockets](/public/multicast.png)

### 6.Working with MultiCast Sockets

```java
public class MulticastSocket
extends DatagramSocket
```

The multicast datagram socket class is useful for sending and receiving IP multicast packets. A MulticastSocket is a (UDP) DatagramSocket, with additional capabilities for joining "groups" of other multicast hosts on the internet.

A multicast group is specified by a class D IP address and by a standard UDP port number. Class D IP addresses are in the range 224.0.0.0 to 239.255.255.255, inclusive. The address 224.0.0.0 is reserved and should not be used.

One would join a multicast group by first creating a MulticastSocket with the desired port, then invoking the joinGroup(InetAddress groupAddr) method:


When a socket subscribes to a multicast `group/port`, it receives datagrams sent by other hosts to the group/port, as do all other members of the group and port. A socket relinquishes membership in a group by the leaveGroup(InetAddress addr) method. Multiple MulticastSocket's may subscribe to a multicast group and port concurrently, and they will all receive group datagrams.

### 7.Constructors
```java
MulticastSocket()
Create a multicast socket.

MulticastSocket(int port)
Create a multicast socket and bind it to a specific port.

MulticastSocket(SocketAddress bindaddr)
Create a MulticastSocket bound to the specified socket address.
```

### 8.Communication With A MultiCast Group

- `Joining a Multicast Group`: The client (receiver) must join the multicast group to start receiving the data. This is done by setting the appropriate options on the socket.

- `Sending Data to a Multicast Group`: The server (sender) sends data to the multicast group's IP address, and the network takes care of delivering the data to all members of the group.