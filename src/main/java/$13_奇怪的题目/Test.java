package $13_奇怪的题目;

import java.util.function.BooleanSupplier;

/**
 * @author yunfeng.lu
 * @create 2017/11/23.
 */
public class Test {
    // 题目
    /**

     if (???){
     System.out.println("true");
     }else {
     System.out.println("false");
     }
     输出
     true
     false
     */
    public static void main(String[] args) {
        if (new BooleanSupplier() {
            @Override
            public boolean getAsBoolean() {
                System.out.println("true");
                return false;
            }
        }.getAsBoolean()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }



}
