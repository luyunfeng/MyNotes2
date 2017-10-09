package $01_Demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by yunfeng.lu on 2017/9/26.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        String pattern = "(\\d+\\.\\d+\\.\\d+\\.\\d+):(\\d+)";
        Pattern r = Pattern.compile(pattern);
        Document doc = Jsoup.connect("http://ip.zdaye.com/dayProxy/2017/9/1.html").get();
        Elements links = doc.select("div.title a");
        List<IpModel> ipModels = new ArrayList<>();
        for (Element link : links) {
            Document docIp = Jsoup.connect("http://ip.zdaye.com" + link.attr("href")).get();
            Elements linksIp = docIp.select("div.cont");
            for (Element linkIp : linksIp) {
                String str = linkIp.text();
                Matcher m = r.matcher(str);
                while (m.find()) {
                    IpModel ipModel = new IpModel();
                    ipModel.setIp(m.group(1));
                    ipModel.setPort(m.group(2));
                    ipModels.add(ipModel);
                }
            }
        }
        System.out.println("总共：" + ipModels.size());
        List<IpModel> ipModels2 = new ArrayList<>();
        for (IpModel ipModel : ipModels) {
            System.out.println(ipModel.toString());
            Boolean isAble = CheckIPUtils.checkValidIP(ipModel.getIp(), Integer.getInteger(ipModel.getPort()));
            if (isAble) {
                System.out.println(ipModel);
                ipModels2.add(ipModel);
            }
        }

        System.out.println("可用：" + ipModels2.size());
    }

    public static void main2(String[] args) {
        String pattern = "(\\d+\\.\\d+\\.\\d+\\.\\d+):(\\d+)";
        Pattern r = Pattern.compile(pattern);
        String str = "113.120.132.122:8118@HTTP#[普匿]山东省济宁市微山县 电信" +
                "165.84.167.54:8080@HTTP#[高匿]香港 宽频网络有限公司" +
                "211.20.151.81:80@HTTP#[未知]台湾省 中华电信(HiNet)" +
                "218.4.158.18:8080@HTTP#[未知]江苏省苏州市 电信" +
                "111.47.221.60:8081@HTTP#[未知]湖北省 移动" +
                "139.199.63.212:9001@HTTP#[透明]广东省广州市 深圳市腾讯计算机系统有限公司IDC机房(电信)";
        Matcher m = r.matcher(str);
        while (m.find()) {
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }
    }


}

class IpModel {
    private String ip;
    private String port;

    @Override
    public String toString() {
        return "IpModel{" +
                "ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
