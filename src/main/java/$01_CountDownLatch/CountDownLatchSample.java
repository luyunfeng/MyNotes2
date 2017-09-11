package $01_CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by yunfeng.lu on 2017/9/11.
 */
public class CountDownLatchSample {
    /**
     * 计数器，用来控制线程
     * 传入参数2，表示计数器计数为2
     */
    private final static CountDownLatch mCountDownLatch = new CountDownLatch(2);
    /**
     * 示例工作线程类
     */
    private static class WorkingThread extends Thread {
        private final String mThreadName;
        private final int mSleepTime;
        public WorkingThread(String name, int sleepTime) {
            mThreadName = name;
            mSleepTime = sleepTime;
        }
        @Override
        public void run() {
            System.out.println("[" + mThreadName + "] started!");
            try {
                Thread.sleep(mSleepTime);
                // 执行一次 count 减一
                mCountDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("[" + mThreadName + "] end!");
        }
    }
    /**
     * 示例线程类
     */
    private static class SampleThread extends Thread {
        @Override
        public void run() {
            try {

                System.out.println("主线程开始等待");
                // 会在这里堵塞，直到 count 为0 或者超时时间达到4秒
                mCountDownLatch.await(4000, TimeUnit.MILLISECONDS);
                System.out.println("主线程结束等待");
            } catch (InterruptedException e) {

            }
        }
    }
    public static void main(String[] args) throws Exception {
        // 最先run SampleThread
        new SampleThread().start();
        // 运行两个工作线程
        // 工作线程1运行5秒
        new WorkingThread("线程一", 5000).start();
        // 工作线程2运行2秒
        new WorkingThread("线程二", 2000).start();

    }
}
