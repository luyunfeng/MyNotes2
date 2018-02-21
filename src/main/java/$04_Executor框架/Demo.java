package $04_Executor框架;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yunfeng.lu on 2017/9/17.
 */
//public class Demo {
//    public static void main(String[] args) {
////        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
////                10, 20, 1000L,
////                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(40),
////                new ThreadPoolExecutor.AbortPolicy());
////
////        for(int i=0;i<10000;i++){
////
////            threadPoolExecutor.submit(new Runnable() {
////                @Override
////                public void run() {
////                    System.out.println("cao");
////                    try {
////                        Thread.sleep(1000);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                }
////            });
////            if(i==10){
////                threadPoolExecutor = new ThreadPoolExecutor(
////                        100, 200, 1000L,
////                        TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(400),
////                        new ThreadPoolExecutor.AbortPolicy());
////
////                System.out.println("最大线程池被修改");
////                System.out.println("此时核心线程数:"+threadPoolExecutor.getCorePoolSize());
////                System.out.println("此时最大线程数"+threadPoolExecutor.getMaximumPoolSize());
////                System.out.println("");
////
////            }
////
////
////        }
//
//
//
//
//}
