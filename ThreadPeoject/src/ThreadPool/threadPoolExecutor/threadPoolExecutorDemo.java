package ThreadPool.threadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class threadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                10,
                20,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5));
            for(int i=0;i<20;i++){
                threadPoolExecutor.submit(new Task(i));
                System.out.println("线程池中线程数目："+threadPoolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
                        threadPoolExecutor.getQueue().size()+"，已执行完的任务数目："+threadPoolExecutor.getCompletedTaskCount());
            }

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
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task"+num+"执行完毕");
    }
}
