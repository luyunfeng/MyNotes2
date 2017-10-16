package $03基于HtmlUnit抓取网页;

import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;

/**
 * Created by yunfeng.lu on 2017/10/10.
 */
public class Demo {

    @Test
    public void test() throws Exception{

        WebClient webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(true);;
        webClient.getOptions().setCssEnabled(false);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setTimeout(100000);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        HtmlPage rootPage = webClient.getPage("http://qun.qq.com/member.html?has_onekey=1#gid=243869917");

        System.out.println(rootPage.asText());

    }
}
