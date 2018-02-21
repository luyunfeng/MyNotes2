package $16_读取json;

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.*;

/**
 * @author yunfeng.lu
 * @create 2018/1/10.
 */
public class Main {

    public static void main(String[] args) {
        // 读取原始json文件并进行操作和输出
        try {
            BufferedReader br = new BufferedReader(new FileReader(
                    "/Users/lucode/Desktop/sql.json"));// 读取原始json文件
            String s = " ", ws = null;
            while ((s = br.readLine()) != null) {


                JSONObject dataJson = new JSONObject(s);// 创建一个包含原始json串的json对象
                JSONArray features = dataJson.getJSONArray("Content");// 找到features的json数组
                for (int i = 0; i < features.length(); i++) {
//
                    JSONObject info = features.getJSONObject(i);// 获取features数组的第i个json对象
//                        JSONObject properties = info.getJSONObject("properties");// 找到properties的json对象
//                        String name = properties.getString("name");// 读取properties对象里的name字段值

                    //System.out.println(info.toString());
                    System.out.println(info.getString("SQL").replaceAll("\n","").
                            replaceAll("   ",""));

                    System.out.println("======================");


                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}

