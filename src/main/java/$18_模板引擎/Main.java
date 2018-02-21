package $18_模板引擎;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;
/**
 * @author yunfeng.lu
 * @create 2018/2/10.
 */
public class Main {
    private final static TemplateEngine templateEngine = new TemplateEngine();

    /**
     * 使用 Thymeleaf 渲染 HTML
     * @param template  HTML模板
     * @param params 参数
     * @return  渲染后的HTML
     */
    public static String render(String template, Map<String, Object> params){
        Context context = new Context();
        context.setVariables(params);
        return templateEngine.process(template, context);
    }




    public static void main(String[] args) {
        String template = "<p th:text='${title}'></p>";
        Map<String, Object> params = new HashMap<>();
        params.put("title", "Thymeleaf 渲染 HTML ---- Anoy");
        String output = Main.render(template, params);
        System.out.println(output);
    }



}
