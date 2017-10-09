package $02_音乐爬虫;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * Created by yunfeng.lu on 2017/9/26.
 */
public class KuGouDemo {
    @Test
    public void test() throws Exception {
        Document doc = Jsoup.connect("http://www.xiami.com/chart/data?page=1&limit=100").get();
        //System.out.println(doc.toString());
        Elements links = doc.select("div.info p strong a");
        for (Element element : links) {
            System.out.println(element.text());
            System.out.println(element.attr("href"));

        }


    }
}
