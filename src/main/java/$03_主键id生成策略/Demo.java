package $03_主键id生成策略;

import java.net.InetAddress;

/**
 * Created by yunfeng.lu on 2017/9/14.
 */
public class Demo {
    public static String formatIp() throws Exception {

        byte[] ip_bytes = InetAddress.getLocalHost().getAddress();
        for (int i=0;i<ip_bytes.length;i++){
            System.out.print(ip_bytes[i]);
        }
        System.out.println();
        System.out.println(ip_bytes.length);
        StringBuilder builder = new StringBuilder("");

        int data = Math.abs(ip_bytes[2]);

        builder.append(new StringBuilder("000").replace(3-String.valueOf(data).length(),3,
                String.valueOf(data)));

        data = Math.abs(ip_bytes[3]);

        builder.append(new StringBuilder("000").replace(3-String.valueOf(data).length(),3,
                String.valueOf(data)));

        return builder.toString();

    }

    public static void main(String[] args) throws Exception{
        //System.out.println(DemoEnum.formatIp());
        byte [] ip={127,-1,-128,-128};
        for (int i=0;i<ip.length;i++) {
            System.out.println(ip[i]);
        }
    }
}
