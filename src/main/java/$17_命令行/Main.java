package $17_命令行;

import cn.hutool.core.io.IoUtil;


/**
 * @author yunfeng.lu
 * @create 2018/1/18.
 */
public class Main {

    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("top");
            int status = 0;
            status = process.waitFor();
            if (status != 0) {
                System.err.println("Failed to call shell's command and the return status's is: " + status);
            } else {
                String s = IoUtil.read(process.getInputStream(), "utf-8");
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
