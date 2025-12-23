import java.net.*;

public class URLExample {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.google.com");
        System.out.println(url.getHost());
    }
}

