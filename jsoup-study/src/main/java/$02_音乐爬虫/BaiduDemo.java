package $02_音乐爬虫;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * Created by yunfeng.lu on 2017/9/26.
 */
public class BaiduDemo {
    @Test
    public void test() throws Exception {
        Document doc = Jsoup.connect("http://music.baidu.com/songlist/504696523").get();
        //System.out.println(doc.toString());
        Elements links = doc.select("span.song-title a");
        for (Element element : links) {
            System.out.println(element.attr("title"));
            System.out.println(element.attr("href"));

        }


    }
}
