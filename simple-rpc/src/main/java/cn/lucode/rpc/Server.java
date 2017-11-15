package cn.lucode.rpc;

import java.io.IOException;

/**
 * @author yunfeng.lu
 * @create 2017/11/15.
 */
public interface Server {
    public void stop();

    public void start() throws IOException;

    public void register(Class serviceInterface, Class impl);

    public boolean isRunning();

    public int getPort();
}
