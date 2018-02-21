package $14_切面;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;

/**
 * @author yunfeng.lu
 * @create 2017/11/27.
 */
public class demo {
    public static void main(String[] args) {
        HelloService helloService=new HelloService();
        helloService.sayHello();
    }

}
@Aspect
class HelloService{
    @After("AfterDemo.function")
    public void sayHello(){
        System.out.println("hello");
    }
}

class AfterDemo{
    @Pointcut("within(*)")
    public void function(){
        System.out.println("after");
    }
}
