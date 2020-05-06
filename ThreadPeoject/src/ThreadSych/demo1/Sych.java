package ThreadSych.demo1;

/**
 * 线程同步
 */
public class Sych {

    public static void main(String[] args) throws InterruptedException {
        OneThread oneThread = new OneThread();
        TwoThread twoThread = new TwoThread();

        oneThread.start();
        twoThread.start();

        oneThread.join();
        twoThread.join();

        System.out.println(Count.count);

    }
}

class Count {
    public static  Object lock = new Object();
    public  static  int count = 0;
}

class OneThread extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Count.lock){ //获取锁
                Count.count++;
            }//释放锁

        }
    }
}

class TwoThread extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Count.lock){
                Count.count++;
            }
        }
    }
}