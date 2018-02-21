package $15_随机数;

import $03_主键id生成策略.TinyUUIDGenerator;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author yunfeng.lu
 * @create 2017/12/4.
 */
public class Demo {
    public static void main(String[] args) {
        //Random random=new Random();
        List list=new ArrayList<>();
//        TInfo tInfo=new TInfo();
//        tInfo.setImageUrl("http://shmetro.oss-cn-shanghai.aliyuncs.com/f6435c4e-f942-40a4-b328-9b94552ed89c.jpg");
//        tInfo.setInfoType("22");
        User user=new User();
        user.setAge(3);
        user.setName("adsd");
        list.add(user);

        //list.add(new TInfo());
        String json = JsonUtil.obj2Json(list);
        System.out.println(json);
        Object o=JsonUtil.json2BeanList(json,TInfo.class);
        System.out.println(o.getClass());


        //System.out.println(JsonUtil.json2Bean(jsonObject.toJSONString(),TInfo.class));
        // list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        list.add("e");
//        list.add("f");
//        System.out.println("大小："+list.size());
//        for(int i=0;i<10;i++){
//            System.out.println(list.get(random.nextInt(list.size()) % (list.size() + 1)));
//
//        }
    }
}
class User{
    private String name;
    private int age;

//    public User(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//    public User() {
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

