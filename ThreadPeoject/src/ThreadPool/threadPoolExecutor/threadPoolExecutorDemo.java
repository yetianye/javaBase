package ThreadPool.threadPoolExecutor;

import java.util.concurrent.*;

/**
 * 手动创建线程池
 */
public class threadPoolExecutorDemo {
    public static void main(String[] args) throws InterruptedException {

        //任务数量，最大线程数 + 队列任务数，超出执行拒绝策略
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                6,
                20,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(9));

        CountDownLatch countDownLatch  = new CountDownLatch(15);


        for(int i=0;i<15;i++){
            threadPoolExecutor.submit(new Task(i,countDownLatch));
            System.out.println("线程池中线程数目："+threadPoolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
                    threadPoolExecutor.getQueue().size()+"，已执行完的任务数目："+threadPoolExecutor.getCompletedTaskCount());

        }

         countDownLatch.await();
         System.out.println(countDownLatch.getCount() + ":线程池执行结束");
         System.out.println(" 线程数:----" + threadPoolExecutor.getTaskCount());

        for(int i=0;i<15;i++){
            threadPoolExecutor.submit(new Task(i,countDownLatch));
            System.out.println("线程池中线程数目："+threadPoolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
                    threadPoolExecutor.getQueue().size()+"，已执行完的任务数目："+threadPoolExecutor.getCompletedTaskCount());

        }

    }
}

 class Task implements Runnable{

    private int num;
    private CountDownLatch countDownLatch;

     public Task(int num,CountDownLatch countDownLatch ){
        this.num=num;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run(){
        System.out.println("正在执行task"+num);
        try {
            Thread.currentThread().sleep(10000);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task"+num+"执行完毕");
    }
}
