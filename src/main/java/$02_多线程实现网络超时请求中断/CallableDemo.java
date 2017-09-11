package $02_多线程实现网络超时请求中断;

import java.util.concurrent.*;

/**
 * Created by yunfeng.lu on 2017/9/11.
 */
public class CallableDemo {

    public static String fun() {
        // 成员内部类
        class CallableThread implements Callable<String> {
            @Override
            public String call() {
                try {
                    // 假设这个是一个耗时的网络 请求
                    Thread.sleep(6000);
                    return "请求返回值";
                } catch (InterruptedException e) {
                    // 假装记录一下日志
                    return null;
                }
            }
        }
        // 开始事件
        long beginTime = System.currentTimeMillis();
        Callable<String> callableThread=new CallableThread();
        FutureTask<String> task= new FutureTask<>(callableThread);
        // 开启线程
        new Thread(task).start();
        String result;
        try {
            // 如果2.5秒没有返回值就 抛出异常
            result = task.get(2500, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            result=null;
        }
        // 结束事件
        long endTime = System.currentTimeMillis();
        System.out.println("cast : " + (endTime - beginTime) / 1000 + " second!");

        if (result!=null){
            return result;
        }else {
            return null;
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(fun());
    }
}
