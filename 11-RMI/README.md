# Java RMI (Remote Method Invocation)

Java RMI is a mechanism that allows one Java Virtual Machine (JVM) to invoke methods on an object running in another JVM. It is used to build distributed applications; through RMI, programs can execute remote functions, where the object is serialized and sent across the network to another JVM, executed there, and the result is serialized and sent back.

## Introduction

Java RMI simplifies the development of distributed Java applications, providing a natural Java-based approach to invoking methods remotely. It uses Java's object serialization mechanism to marshal and unmarshal parameters and does not truncate types, meaning that rich object-oriented data structures can be used.

![RMI Architecture](data:image/jpeg;base64,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)

RMI uses two key pieces:

- **Stubs and Skeletons**: When using RMI, the calling side interacts with what's known as a "stub" (a stand-in for the remote object). The called side then uses a "skeleton" to invoke methods on the actual remote object.

- **RMI Registry**: A simple server-side naming registry where remote objects register their names when their services are started. Clients can then look up remote objects and make remote method calls.

## Implementation Steps

### 1. Define the Remote Interface

Your interface should extend the `java.rmi.Remote` interface and define the remote methods. Every method should throw a `RemoteException`.

```java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String sayHello() throws RemoteException;
}
```
### 2.Marshalling and Unmarshalling
Whenever a client invokes a method that accepts parameters on a remote object, the parameters are bundled into a message before being sent over the network. These parameters may be of primitive type or objects. In case of primitive type, the parameters are put together and a header is attached to it. In case the parameters are objects, then they are serialized. This process is known as marshalling.

At the server side, the packed parameters are unbundled and then the required method is invoked. This process is known as unmarshalling.



### 2. Implement the Remote Interface

After defining the remote interface, the next step is to provide an implementation for it. This class, often referred to as the "remote object," will perform the actual operations when a remote method is invoked.

#### Steps to Implement the Remote Interface:

1. **Extend `UnicastRemoteObject`**: The implementation class should extend the `java.rmi.server.UnicastRemoteObject` class. This is required to create and export a remote object.

2. **Implement the Remote Interface**: Declare that your class implements the previously defined remote interface.

3. **Provide a Constructor**: The constructor of this class should handle the potential `RemoteException` that might be thrown. This is often done by simply calling the superclass constructor using `super()`.

4. **Implement the Remote Methods**: Provide concrete implementations for all the methods declared in the remote interface.

Here's a sample implementation based on the `Hello` interface:

```java
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class HelloImpl extends UnicastRemoteObject implements Hello {
    
    // Constructor
    public HelloImpl() throws RemoteException {
        super();
    }

    // Implement the remote method
    @Override
    public String sayHello() throws RemoteException {
        return "Hello, world!";
    }
}
```


### 3. Implement the Server

After implementing the remote interface, you need to set up the server that will host and provide the RMI service. 

The server will:

1. Create an instance of the remote object.
2. Register this object with the RMI registry so that it can be accessed by the client.

Here's how you can do it:

```java
import java.rmi.Naming;
import java.rmi.RemoteException;

public class HelloServer {
    public static void main(String args[]) {
        try {
            HelloImpl obj = new HelloImpl();
            Naming.rebind("//localhost/HelloServer", obj);
            System.out.println("HelloServer bound in registry");
        } catch (Exception e) {
            System.out.println("HelloServer error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

### 4. Create the Client

Once the server is set up and the remote object is bound to the RMI registry, the next step is to create a client that will access this remote object and invoke its methods.

Here's how you can implement the client:

```java
import java.rmi.Naming;

public class HelloClient {
    public static void main(String args[]) {
        try {
            Hello stub = (Hello) Naming.lookup("//localhost/HelloServer");
            String response = stub.sayHello();
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println("HelloClient exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
```

## Compilation & Execution


### Execution Steps

1. **Compile all the Java files:**:
   Navigate to the directory containing your Java files (Hello.java, HelloImpl.java, HelloServer.java, and HelloClient.java) and compile them using:
   ```bash
   javac -source 11 -target 11 *.java
   ```


2. **Generate the Stub files:**:
   Use the rmic tool to generate stubs for your remote object implementation::
   ```bash
   rmic HelloImpl
   ```

3. **Start the RMI Registry**:
   After compiling the Java files, navigate to the directory containing the compiled `.class` files. Start the RMI registry either in the background or in a new terminal window:
   ```bash
   rmiregistry &
   ```

4. **Start the Server:**:
   In the original terminal, start the server application:
   ```bash
   java HelloServer
   ```
5. **Run the Client:**:
   Once the server is running and the remote object is registered, you can start the client in a separate terminal:
   ```bash
   java HelloClient
   ```   