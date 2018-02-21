package $15_随机数;

/**
 * @author yunfeng.lu
 * @create 2017/12/4.
 */
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonUtil {

    public static <T> List<T> json2BeanList(String json, Class<T> cls) {
        return JSON.parseArray(json, cls);
    }

    public static <T> T json2Bean(String json, Class<T> cls) {
        return JSON.parseObject(json, cls);
    }

    public static String obj2Json(Object obj) {
        String json = JSON.toJSONString(obj);
        return json;
    }

    public static String map2JsonWriteMapNullValue(Map map) {
        String json = JSONObject.toJSONString(map, new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
        return json;
    }

    public static String obj2JsonWriteNullValue(Object o) {
        return JSON.toJSONString(o, new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
    }

    public static <T> Map<String, T> json2Map(String json) {
        return (Map)JSON.parse(json);
    }

    public static Object jsonObj2Obj(JSONObject jsonObject) {
        return jsonObject != null?JSONObject.parse(jsonObject.toJSONString()):null;
    }

}
