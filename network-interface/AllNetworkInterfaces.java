import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class AllNetworkInterfaces {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                
                System.out.println(networkInterface);
                
                String name = networkInterface.getName();
                System.out.println("Name:"+name);
                
                String displayName = networkInterface.getDisplayName();
                System.out.println("Display name: "+displayName);
                
                int index = networkInterface.getIndex();
                System.out.println("Index: " + index);
                
                int hashCode = networkInterface.hashCode();
                System.out.println("Hashcode: "+ hashCode);

                System.out.println("\n Inet address:");
                Enumeration<InetAddress> inetAddresses  = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress  address = inetAddresses.nextElement();
                    System.out.println(address);
                }
                
                System.out.println("\n");
            }
            
        }
        catch (SocketException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
