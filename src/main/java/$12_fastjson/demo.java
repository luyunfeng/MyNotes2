package $12_fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yunfeng.lu
 * @create 2017/11/22.
 */
public class demo {
    public static void main(String[] args) {
        Map< String , Object > jsonMap = new HashMap< String , Object>();
        User user=new User();
        user.setAge("22");
        User user2=new User();
        user2.setAge("23");
        List<User> list=new ArrayList<User>();
        list.add(user);
        list.add(user2);
        jsonMap.put("list",list);

        String str = map2JsonWriteMapNullValue(jsonMap);
        Map map=json2Map(str);
        System.out.println(map);
        List list1=(List) map.get("list");

        System.out.println(json2Bean(list1.get(0).toString(),User.class));
        //System.out.println(((JSONObject)list1.get(0)).get("age"));
        //System.out.println(((User)jsonStrToJavaBeanList(map.get("list").toString()).get(0)).getAge());
    }
    public static <T> T json2Bean(String json, Class<T> cls) {
        return JSON.parseObject(json, cls);
    }

    public static String map2JsonWriteMapNullValue(Map map) {
        String json = JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue);
        return json;
    }
    public static  List jsonStrToJavaBeanList(String str){
        List<User> users = JSON.parseObject(str, new TypeReference<List<User>>() {});
        return users;
    }
    @SuppressWarnings("unchecked")
    public static <T> Map<String,T> json2Map(String json) {
        return (Map<String,T>)JSON.parse(json);
    }

}
class  User{
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

