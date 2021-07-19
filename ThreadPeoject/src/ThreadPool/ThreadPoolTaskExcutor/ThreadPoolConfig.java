package ThreadPool.ThreadPoolTaskExcutor;


import java.util.concurrent.CountDownLatch;

/**
 *    Spring中的 ThreadPoolTaskExecutor
 */
public class ThreadPoolConfig {
//    public static ThreadPoolTaskExecutor threadPoolTaskExecutort = new ThreadPoolTaskExecutor();
//
//    static{
//        threadPoolTaskExecutort.initialize();
//        threadPoolTaskExecutort.setCorePoolSize(6);
//        threadPoolTaskExecutort.setMaxPoolSize(8);
//        threadPoolTaskExecutort.setQueueCapacity(10000);
//        threadPoolTaskExecutort.setKeepAliveSeconds(300);
//        threadPoolTaskExecutort.setAllowCoreThreadTimeOut(true);
//    }
//
//    public static int activeCount(){
//        return ThreadPoolConfig.threadPoolTaskExecutort.getActiveCount();
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(10);
//        for(int i=0;i<10;i++){
//            ThreadPoolConfig.threadPoolTaskExecutort.execute(new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("线程" + Thread.currentThread().getId() + "开始出发");
//
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println("线程" + Thread.currentThread().getId() + "已到达终点");
//
//                    countDownLatch.countDown();
//                }
//            }));
//
//        }
//        try {
//            countDownLatch.await();
//            System.out.println("执行完毕");
//            Thread.sleep(10000L);
//            System.out.println("线程池线程存活个数："+threadPoolTaskExecutort.getActiveCount());
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Thread.sleep(5000L);
//        ThreadPoolConfig.threadPoolTaskExecutort.execute(new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("任务执行，线程池线程存活个数：" + threadPoolTaskExecutort.getActiveCount());
//            }
//        }));
//        Thread.sleep(10000L);
//        System.out.println("线程池线程存活个数："+threadPoolTaskExecutort.getActiveCount());
//
//    }
}
