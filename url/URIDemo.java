
// Java program to illustrate various URI class methods 
import java.net.*;

class URIDemo {
    public static void main(String[] args) throws Exception {
        String uribase = "https://www.geeksforgeeks.org/";
        String urirelative = "languages/../java";
        String str = "https://www.google.co.in/?gws_rd=ssl#" + ""
                + "q=networking+in+java+geeksforgeeks" + ""
                + "&spf=1496918039682";

        // Constructor to create a new URI by parsing the string
        URI uriBase = new URI(uribase);

        // create() method
        URI uri = URI.create(str);

        System.out.println("Base URI = " + uriBase.toString());

        URI uriRelative = new URI(urirelative);
        System.out.println("Relative URI = " + uriRelative.toString());

        URI uriResolved = uriBase.resolve(uriRelative);
        System.out.println("Resolved URI = " + uriResolved.toString());

        URI uriRelativized = uriBase.relativize(uriResolved);
        System.out.println("Relativized URI = " + uriRelativized.toString());

        System.out.println(uri.normalize().toString());

        System.out.println("Scheme = " + uri.getScheme());

        System.out.println("Raw Scheme = " + uri.getRawSchemeSpecificPart());

        System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());

        System.out.println("Raw User Info = " + uri.getRawUserInfo());

        System.out.println("User Info = " + uri.getUserInfo());

        System.out.println("Authority = " + uri.getAuthority());

        System.out.println("Raw Authority = " + uri.getRawAuthority());

    }
}
