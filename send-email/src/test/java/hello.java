import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunfeng.lu on 2017/10/14.
 */
public class hello {
    static int  num;
    public static void main(String[] args) {
        hello hello=new hello();
        hello.fun();
    }

    public  void fun() {
        System.out.println(num++);
        fun();
    }
}
