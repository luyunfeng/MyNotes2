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
        HtmlPage rootPage = webClient.getPage("http://blog.csdn.net/a6833916180/article/details/51261009");

        System.out.println(rootPage.asText());

    }
}
