package cn.lucode.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author yunfeng.lu
 * @create 2017/11/15.
 */
public class RPCTest {
    public static void main(String[] args) throws IOException {
        // 启动服务端
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8088);
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        HelloService service =
                RPCClient.getRemoteProxyObj(HelloService.class,
                        new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("test"));
    }
}
