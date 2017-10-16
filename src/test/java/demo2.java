import java.util.HashMap;
import java.util.Map;

/**
 * Created by yunfeng.lu on 2017/9/25.
 */
public class demo2 {
    public static void main(String[] args) {
        String s=null;
        Map<String,Object> map=new HashMap<>();
        map.put("s",s);
        System.out.println((String)map.get("s"));

//        A a=new A();
//        B b=new B();
//        b.setName(a.getName());
//        System.out.println(b.getName());
        //System.out.println(integer.equals("1"));

    }
}
class A{
    private String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class B{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
