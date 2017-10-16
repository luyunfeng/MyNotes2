package lucodemail;

import jetbrick.template.JetEngine;
import jetbrick.template.JetTemplate;

import javax.mail.MessagingException;
import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yunfeng.lu on 2017/10/12.
 */
public class Main {
    public static void main(String[] args) throws MessagingException {

        JetEngine engine = JetEngine.create();
        JetTemplate template = engine.getTemplate("/Users/lucode/Desktop/code/笔记/MyNotes2/send-email/target/classes/register.jetx");

        Map<String, Object> context = new HashMap<String, Object>();
        context.put("username", "煞笔");
        context.put("email", "haha@java-china.org");
        context.put("url", "<a href='http://blog.luyunfeng.cn'>点击有惊喜</a>");

        StringWriter writer = new StringWriter();
        template.render(context, writer);
        String output = writer.toString();


        OhMyEmail.subject("这是一封测试Jetx模板邮件")
                .from("lucode的QQ邮箱")
                .to("676692273@qq.com")
                .html(output)
                .send();
    }
}
