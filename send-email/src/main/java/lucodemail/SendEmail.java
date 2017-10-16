//package lucodemail;
//
//import javax.mail.internet.MimeMessage;
//import java.io.File;
//
///**
// * Created by yunfeng.lu on 2017/10/11.
// */
//public class SendEmail {
//    public void sendHtml(Email mail) throws Exception {
//        MailUtil mailUtil = new MailUtil();
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setFrom(USER_NAME);
//        helper.setTo(mail.getEmail());
//        helper.setSubject(mail.getSubject());
//        helper.setText(
//                "<html><body><img src=\"cid:springcloud\" ></body></html>",
//                true);
//        // 发送图片
//        File file = ResourceUtils.getFile("classpath:static"
//                + Constants.SF_FILE_SEPARATOR + "image"
//                + Constants.SF_FILE_SEPARATOR + "springcloud.png");
//        helper.addInline("springcloud", file);
//        // 发送附件
//        file = ResourceUtils.getFile("classpath:static"
//                + Constants.SF_FILE_SEPARATOR + "file"
//                + Constants.SF_FILE_SEPARATOR + "关注科帮网获取更多源码.zip");
//        helper.addAttachment("科帮网", file);
//        mailUtil.startHtml(mailSender, message);
//    }
//}
