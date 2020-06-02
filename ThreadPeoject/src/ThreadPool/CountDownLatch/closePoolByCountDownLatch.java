package ThreadPool.CountDownLatch;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用CountDownLatch 关闭线程池
 */
public class closePoolByCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(20);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
            15,
            20,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(5));

        for (int i = 0; i < 20; i++) {
            String namm = "T:" + Math.random();
            threadPoolExecutor.submit(new YeThread(namm,countDownLatch));
        }
        try {
            threadPoolExecutor.shutdown();
            System.out.println("线程池状态：" + threadPoolExecutor.isTerminated());;
            countDownLatch.await();//阻塞主线程
            System.out.println("-----------结束-----------");
            System.out.println("已执行完线程：" + threadPoolExecutor.getCompletedTaskCount());;
            System.out.println("线程池状态：" + threadPoolExecutor.isTerminated());;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class YeThread extends Thread{
    private String name;

    private CountDownLatch countDownLatch;

    public YeThread(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(name + ":" + "开始执行---");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + ":" + "执行结束！");
        countDownLatch.countDown();//计数
    }

}
