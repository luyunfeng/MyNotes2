
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

import jetbrick.template.JetEngine;
import jetbrick.template.JetTemplate;
import lucodemail.OhMyEmail;
import org.junit.Before;
import org.junit.Test;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

import static lucodemail.OhMyEmail.SMTP_163;
import static lucodemail.OhMyEmail.SMTP_QQ;

/**
 * Created by yunfeng.lu on 2017/10/11.
 */

public class OhMyEmailTest {

    @Before
    public void before() throws GeneralSecurityException {
        // 配置，一次即可
        OhMyEmail.config(SMTP_QQ(false), "676692273@qq.com", "hphtuxxbpioqbdci");
    }

    @Test
    public void testSendText() throws MessagingException {
        OhMyEmail.subject("这是一封测试TEXT邮件")
                .from("王爵的QQ邮箱")
                .to("676692273@qq.com")
                .text("信件内容")
                .send();
    }

    @Test
    public void testSendHtml() throws MessagingException {
        OhMyEmail.subject("这是一封测试HTML邮件")
                .from("lucode")
                .to("yunfeng.lu@bangdao-tech.com")
                .html("<h1 font=red>信件内容</h1>" +
                        "<img src=\"//upload-images.jianshu.io/upload_images/1442902-fcdb4fd0203ebc7e.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240\" style=\"cursor: zoom-in;\">")
                .send();
    }

    @Test
    public void testSendAttach() throws MessagingException {
        OhMyEmail.subject("这是一封测试附件邮件")
                .from("王爵的QQ邮箱")
                .to("921293209@qq.com")
                .html("<h1 font=red>信件内容</h1>")
                .attach(new File("/Users/biezhi/Downloads/hello.jpeg"), "测试图片.jpeg");
//                .send();
    }


    @Test
    public void testPebble() throws IOException, PebbleException, MessagingException {
        PebbleEngine engine = new PebbleEngine.Builder().build();
        PebbleTemplate compiledTemplate = engine.getTemplate("register.html");

        Map<String, Object> context = new HashMap<String, Object>();
        context.put("username", "biezhi");
        context.put("email", "admin@java-china.org");

        Writer writer = new StringWriter();
        compiledTemplate.evaluate(writer, context);

        String output = writer.toString();
        System.out.println(output);

        OhMyEmail.subject("这是一封测试Pebble模板邮件")
                .from("lucode")
                .to("yunfeng.lu@bangdao-tech.com")
                .html(output)
                .attach(new File("/Users/lucode/Desktop/秒杀购物单.xlsx"),"秒杀购物单.xlsx")
                .send();
    }

    @Test
    public void testJetx() throws IOException, PebbleException, MessagingException {

        JetEngine engine = JetEngine.create();
        JetTemplate template = engine.getTemplate("classpath:register.jetx");

        Map<String, Object> context = new HashMap<String, Object>();
        context.put("username", "煞笔");
        context.put("email", "haha@java-china.org");
        context.put("url", "<a href='http://blog.luyunfeng.cn'>点击有惊喜</a>");

        StringWriter writer = new StringWriter();
        template.render(context, writer);
        String output = writer.toString();
        System.out.println(output);

        OhMyEmail.subject("这是一封测试Jetx模板邮件")
                .from("lucode的QQ邮箱")
                .to("676692273@qq.com")
                .html(output)
                .send();
    }

}
