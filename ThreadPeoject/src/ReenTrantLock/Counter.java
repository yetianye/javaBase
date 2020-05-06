package ReenTrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private  Lock lock = new ReentrantLock();
    private int count = 0;
    public  void add (){
        try {
            lock.lock();
            count++;
        } finally {
            //lock.unlock();
        }
    }

    public  void dec() throws InterruptedException {
        System.out.println("dec 正在获取锁----");
        if(lock.tryLock(2, TimeUnit.SECONDS)){
            System.out.println("dec 获取到锁了---");
            try{
                count --;
            }finally {
                lock.unlock();
            }
        }else{
            System.out.println("dec 放弃获取锁");
        }
    }

    public int getCount() {
        return count;
    }
}
class Main{
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    counter.add();
                    System.out.println("thread 1 获取 ：" + counter.getCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    counter.dec();
                    System.out.println("thread 2 获取 ：" + counter.getCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("end : " + counter.getCount());
    }
}
