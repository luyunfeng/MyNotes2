package $07_字符替换;

/**
 * @author yunfeng.lu
 * @create 2017/10/26.
 */
public class Demo {
    public static void main(String[] args) {
        String s = "sss||sss|sss|";
        System.out.println(s.replace("|", "#"));
        System.out.println(s.replaceAll("[|]", "#"));
    }
}
