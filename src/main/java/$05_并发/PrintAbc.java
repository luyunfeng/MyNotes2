package $05_并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yunfeng.lu
 * @create 2017/10/16.
 */
public class PrintAbc {
    static volatile Boolean isPrintA = true;
    static volatile Boolean isPrintB = false;
    static volatile Boolean isPrintC = false;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (PrintAbc.class) {
                        while (!isPrintA) {
                            try {
                                PrintAbc.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        System.out.println("A");
                        isPrintC = false;
                        isPrintB = true;
                        isPrintA = false;
                        PrintAbc.class.notifyAll();
                    }

                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    synchronized (PrintAbc.class) {
                        while (!isPrintB) {
                            try {
                                PrintAbc.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("B");
                        isPrintC = true;
                        isPrintB = false;
                        isPrintA = false;
                        PrintAbc.class.notifyAll();
                    }
                }

            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (PrintAbc.class) {
                        while (!isPrintC) {
                            try {
                                PrintAbc.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        System.out.println("C");
                        isPrintC = false;
                        isPrintB = false;
                        isPrintA = true;
                        PrintAbc.class.notifyAll();
                    }

                }
            }
        });
    }
}
