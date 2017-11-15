package $08_异常;

/**
 * @author yunfeng.lu
 * @create 2017/11/2.
 */
public class Demo {

    public static void main(String[] args) {
        try {
            Demo demo=new Demo();
            demo.fun();
        }catch (Exception e){
            System.out.println("异常被捕获");
        }

    }

    public void fun() throws Exception {
        int i = 0;
        if (i == 0) {
            throw new RuntimeException();
        }

    }




}
