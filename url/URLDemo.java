import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {

        // Main driver method
        @SuppressWarnings("deprecation")
        public static void main(String[] args)
                        throws MalformedURLException {

                // Creating a URL with string representation
                URL url1 = new URL(
                                "https://prem@www.premgautam.com/about?job=programming#butwal");

                // Creating a URL with a protocol,hostname,and path
                URL url2 = new URL("http", "www.geeksforgeeks.org",
                                "/jvm-works-jvm-architecture/");

                URL url3 = new URL(
                                "https://www.google.co.in/search?"
                                                + "q=gnu&rlz=1C1CHZL_enIN71"
                                                + "4IN715&oq=gnu&aqs=chrome..69i57j6"
                                                + "9i60l5.653j0j7&sourceid=chrome&ie=UTF"
                                                + "-8#q=geeks+for+geeks+java");

                // string representation of the URL
                System.out.println(url1.toString());
                System.out.println(url2.toString());

                System.out.println();
                System.out.println("Different components of the URL3-");

                // protocol for the URL
                System.out.println("Protocol:- " + url1.getProtocol());

                // hostname of the url
                System.out.println("Hostname:- " + url1.getHost());

                //  default port
                System.out.println("Default port:- " + url1.getDefaultPort());

                // query part of URL
                System.out.println("Query:- " + url1.getQuery());

                // path of URL
                System.out.println("Path:- " + url1.getPath());

                // file name
                System.out.println("File:- " + url1.getFile());

                //  reference
                System.out.println("Reference:- " + url1.getRef());

                // user info
                System.out.println("User info: " + url1.getUserInfo());

        }
}
