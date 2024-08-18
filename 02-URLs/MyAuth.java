import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;

class MyAuthenticator extends Authenticator {
    private String username;
    private String password;

    public MyAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password.toCharArray());
    }
}

public class MyAuth {
    public static void main(String[] args) {
        String data;
        try {
            // Set the default authenticator
            Authenticator.setDefault(new MyAuthenticator("John", "pass123"));

            // Create the URL object
            @SuppressWarnings("deprecation")
            URL url = new URL("https://www.educba.com/");

            // Read data from the URL
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            System.out.println("The requesting URL is : " + url.getHost());

            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}