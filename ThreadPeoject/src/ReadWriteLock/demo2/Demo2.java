package ReadWriteLock.demo2;

import java.util.Currency;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  独写互斥 例子
 */
public class Demo2 {
    public static void main(String[] args) {
        Servie servie = new Servie();
        //先执行写入线程。写入线程执行结束后才会同时执行读取线程
        new Thread(){
            @Override
            public void run() {
                servie.write();
            }
        }.start();

        for (int i = 0; i < 6; i++) {
            new Thread(){
                @Override
                public void run() {
                    servie.read();
                }
            }.start();
        }


    }
}

class Servie {
    final private ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void read(){
        readLock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + ":" + "正在读取----");
        }finally {
            readLock.unlock();
        }
    }

    public void write(){
        writeLock.lock();
        try{
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + ":" + "正在写入----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

}
