package test;

import java.util.concurrent.*;

/**
 * 手动创建线程池
 */
public class threadPoolExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                10,
                20,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5));

        CountDownLatch countDownLatch  = new CountDownLatch(15);

        CopyOnWriteArrayList arrayList = new CopyOnWriteArrayList();

        for(int i=0;i<15;i++){
            threadPoolExecutor.submit(new Task(i,countDownLatch,arrayList));
            System.out.println("线程池中线程数目："+threadPoolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
                    threadPoolExecutor.getQueue().size()+"，已执行完的任务数目："+threadPoolExecutor.getCompletedTaskCount());

        }

         countDownLatch.await();
         System.out.println(countDownLatch.getCount() + ":线程池执行结束");
         System.out.println(" 线程数:----" + threadPoolExecutor.getTaskCount());
         System.out.println("数量 ： " + arrayList.size());
        arrayList= null;

    }
}

class Task implements Runnable{

   private int num;
   private CountDownLatch countDownLatch;
   private  CopyOnWriteArrayList arrayList;

    public Task(int num,CountDownLatch countDownLatch ,CopyOnWriteArrayList arrayList){
       this.num=num;
       this.countDownLatch = countDownLatch;
       this.arrayList=arrayList;
   }

   @Override
   public void run(){
       System.out.println("正在执行task"+num);
       for (int i = 0; i < 30000; i++) {
           arrayList.add(i);
       }
       countDownLatch.countDown();
       System.out.println("task"+num+"执行完毕");
   }
}
