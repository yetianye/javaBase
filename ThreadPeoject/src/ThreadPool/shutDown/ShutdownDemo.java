package ThreadPool.shutDown;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ShutdownDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                20,
                20,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5));

            for(int i=0;i<20;i++){
                threadPoolExecutor.submit(new Task(i));
                System.out.println("线程池中线程数目："+threadPoolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
                        threadPoolExecutor.getQueue().size()+"，已执行完的任务数目："+threadPoolExecutor.getCompletedTaskCount());
            }

            //关闭线程池
            threadPoolExecutor.shutdown();
            //阻塞线程一分钟,如果线程池线程都跑完了。就会放弃阻塞。否则 10分钟之后放开阻塞。
            //threadPoolExecutor.awaitTermination(5,TimeUnit.SECONDS);

            //也可以通过线程池状态 判断是否执行完
            while(!threadPoolExecutor.isTerminated()){
                Thread.sleep(1000);
                System.out.println("阻塞中。");
            }

            System.out.println("线程池中线程数目："+threadPoolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
                    threadPoolExecutor.getQueue().size()+"，已执行完的任务数目："+threadPoolExecutor.getCompletedTaskCount());


    }
}

class Task implements Runnable{

   private int num;

   public Task(int num){
       this.num=num;
   }

   @Override
   public void run(){
       System.out.println("正在执行task"+num);
       try {
           Thread.currentThread().sleep(10000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println("task"+num+"执行完毕");
   }
}
