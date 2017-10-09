package $01_Demo;

import sun.net.www.http.HttpClient;

import java.net.*;

/**
 * Created by yunfeng.lu on 2017/9/22.
 */
public class CheckIPUtils {


    public static Boolean checkValidIP(String ip, Integer port) {
        System.out.println(ip+port);
        SocketAddress addr = new InetSocketAddress(ip, port);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
        try{
            URL url = new URL("https://www.baidu.com");
            URLConnection conn = url.openConnection(proxy);
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 7.0; NT 5.1; GTB5; .NET CLR 2.0.50727; CIBA)");
            conn.getContent();
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(CheckIPUtils.checkValidIP("103.228.246.36", 8080));
    }
}