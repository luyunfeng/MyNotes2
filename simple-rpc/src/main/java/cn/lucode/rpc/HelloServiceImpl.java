package cn.lucode.rpc;

/**
 * @author yunfeng.lu
 * @create 2017/11/15.
 */
public class HelloServiceImpl  implements HelloService{
    /**
     * 接口
     *
     * @param name
     * @return
     */
    @Override
    public String sayHi(String name) {
        return "say "+name;
    }
}
