package cn.lucode.demo;

import org.ansj.splitWord.analysis.ToAnalysis;

/**
 * @author yunfeng.lu
 * @create 2017/10/22.
 */
public class demo {
    public static void main(String[] args) {
        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        System.out.println(ToAnalysis.parse(str));
    }
}
