package $06_钉钉机器人;

import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * @author yunfeng.lu
 * @create 2017/10/25.
 */

public class Demo {
    private final static String API = "https://oapi.dingtalk.com/robot/send?access_token=14d53c2ccd5e58af82d51d2b86ae8deb5fe95ad41c8966a767db87c1c92bf596";

    private final static String TYPE_TEXT = "text";

    /**
     * 文本留言到钉钉
     */
    public static void textMessage(MessageBean messageBean) {

        String content = "{\"msgtype\": \"" + TYPE_TEXT + "\", \"text\": {\"content\": \"" + messageBean.getNickname() + "\n" + messageBean.getEmail() + "\n" + messageBean.getContent() + "\"}}";
        try {
            Jsoup.connect(API).header("Content-Type", "application/json").requestBody(content).ignoreContentType(true).post();
        } catch (IOException e) {
            System.out.println("发送失败");
        }
    }

    public static void main(String[] args) {
        MessageBean messageBean=new MessageBean();
        messageBean.setContent("朱文杰大帅比");
        messageBean.setEmail("dsdadasd@qq.com");
        messageBean.setNickname("122");
        textMessage(messageBean);

    }
}
class MessageBean {

    private String nickname;

    private String email;

    private String content;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
