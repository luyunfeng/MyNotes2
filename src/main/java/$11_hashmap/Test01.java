package $11_hashmap;

import java.util.*;

/**
 * @author yunfeng.lu
 * @create 2017/11/21.
 */
public class Test01 {

    public static void main(String[] args) {
        Test01 test01=new Test01();
        Map<String,Object> map=new HashMap<>();
        List<String> list=new ArrayList<>();
        list.add("dddd");
        list.add("eee");
        list.add("qqq");
        map.put("list",list);
        test01.fun(map);
        //System.out.println(map);
    }

    public void fun(Map map){
        map.put("hehe","oo");
        List<String> list=(List)map.get("list");
        Random random = new Random();
        System.out.println(list.get(random.nextInt(list.size()) % (list.size() + 1)));
        System.out.println(list.get(random.nextInt(list.size()) % (list.size() + 1)));
        System.out.println(list.get(random.nextInt(list.size()) % (list.size() + 1)));
    }

}
