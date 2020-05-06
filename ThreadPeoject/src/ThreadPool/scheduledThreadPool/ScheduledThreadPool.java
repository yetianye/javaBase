package ThreadPool.scheduledThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时调度线程池
 * 
 */
public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService excutor = Executors.newScheduledThreadPool(2);

        excutor.scheduleAtFixedRate(()->{
            System.out.println("执行");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },0, 2, TimeUnit.SECONDS);

        // 定时调度，第二个任务执行的时间 = 第一个任务执行时间 + `delay`
        excutor.scheduleWithFixedDelay(() -> {
            System.out.println(22222222);
        }, 0, 3, TimeUnit.SECONDS);
    }
}
