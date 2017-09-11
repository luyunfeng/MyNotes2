# CountDownLatch是什么？
CountDownLatch是在java1.5被引入的，跟它一起被引入的并发工具类还有CyclicBarrier、Semaphore、ConcurrentHashMap和BlockingQueue;
它们都存在于java.util.concurrent包下。
# CountDownLatch能做什么？
CountDownLatch这个类能够使一个线程等待其他线程完成各自的工作后再执行。

# CountDownLatch内部如何实现的？
CountDownLatch是通过一个计数器来实现的，计数器的初始值为线程的数量。每当一个线程完成了自己的任务后，计数器的值就会减1。当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。

![原理图.png](http://upload-images.jianshu.io/upload_images/4031250-bbe675c0f976b23c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

构造器中的计数值（count）实际上就是闭锁需要等待的线程数量。
这个值只能被设置一次，而且CountDownLatch没有提供任何机制去重新设置这个计数值。
与CountDownLatch的第一次交互是主线程等待其他线程。
主线程必须在启动其他线程后立即调用CountDownLatch.await()方法。这样主线程的操作就会在这个方法上阻塞，直到其他线程完成各自的任务。
其他N个线程必须引用闭锁对象，因为他们需要通知CountDownLatch对象，
他们已经完成了各自的任务。这种通知机制是通过 CountDownLatch.countDown()方法来完成的；每调用一次这个方法，在构造函数中初始化的count值就减1。所以当N个线程都调 用了这个方法，count的值等于0，然后主线程就能通过await()方法，恢复执行自己的任务。