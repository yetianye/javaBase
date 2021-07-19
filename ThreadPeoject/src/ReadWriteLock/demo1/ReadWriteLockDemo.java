package ReadWriteLock.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 =  new Thread(()->{
            counter.add();
        });
        Thread t2 =  new Thread(()->{
            counter.getCount();
        });

    }
}

class Counter {
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock readLock = rwlock.readLock();
    private final Lock writeLock = rwlock.writeLock();
    private int count = 0;
    //写使用写锁
    public void add (){
        writeLock.lock();
        try{
            this.count++;
        }finally {
            writeLock.unlock();
        }

    }
    //读使用读锁
    public int getCount(){
        readLock.lock();
        try{
            return this.count;
        }finally {
            readLock.unlock();
        }
    }

}