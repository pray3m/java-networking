import java.net.*;

public class SpamCheck {
    public static void main(String[] args) {
        String websiteSuffix = ".sbl.spamhaus.org";

        // Hardcoded IP address and domain for checking
        String[] checks = { "192.0.2.1", "example.com" };

        for (String input : checks) {
            String query = input + websiteSuffix;

            try {
                InetAddress.getByName(query);
                System.out.println(input + " is listed as spam.");
            } catch (Exception e) {
                System.out.println(input + " appears legit.");
            }
        }
    }
}
