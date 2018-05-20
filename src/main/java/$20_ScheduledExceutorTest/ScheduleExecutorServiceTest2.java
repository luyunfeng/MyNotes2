package $20_ScheduledExceutorTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yunfeng.lu
 * @create 2018/3/20.
 */
public class ScheduleExecutorServiceTest2 {
    public static void main(String[] args) {
        ScheduleExecutorServiceTest2 test = new ScheduleExecutorServiceTest2();
        test.testAtFixedRate();
    }

    private ScheduledExecutorService executor;

    public ScheduleExecutorServiceTest2() {
        executor = Executors.newScheduledThreadPool(4);
    }

    public void testAtFixedRate() {
        executor.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.println("====");
                try {
                    Thread.sleep(1000);
                    System.out.println("执行完毕");
                    int i = 1 / 0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1000, 3000, TimeUnit.MILLISECONDS);
    }

    public void testWithFixedDelay() {
        executor.scheduleWithFixedDelay(new Runnable() {

            @Override
            public void run() {
                System.out.println("====");
                try {
                    int i = 1 / 0;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /*
                try {
                    Thread.sleep(10000);
                    System.out.println("执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                */
            }
        }, 1000, 3000, TimeUnit.MILLISECONDS);
    }

}
