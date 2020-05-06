package ThreadPool.fixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FixedThreadPool 基本用法
 */
public class FixedThreadPool {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new myRunnale(i));
        }
        executorService.shutdown();
    }
}

/**
 * 实现runnable
 */
class myRunnale implements Runnable{
    private int task;

    public myRunnale(int task) {
        this.task = task;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-task : " + task );
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
