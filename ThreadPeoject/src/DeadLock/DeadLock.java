package DeadLock;

/**
 *  死锁
 *  两个线程各自持有不同的锁，然后各自试图获取对方手里的锁，造成了双方无限等待下去，这就是死锁。
 *  1.线程1先获取A锁，线程2先获取B锁，
 *  2.线程1要获取B锁，线程2要获取A锁，但是a锁、和b锁没有释放。
 *  3.导致死锁
 *  4.正确方法，改变获取锁的顺寻，线程1 和线程2 都先获取A锁，这样，其中一个线程先释放A锁，另一个线程就可以获取A锁了。
 *
 *  死锁的四个必要条件：
 * 互斥条件：进程对所分配到的资源不允许其他进程进行访问，若其他进程访问该资源，只能等待，直至占有该资源的进程使用完成后释放该资源
 * 请求和保持条件：进程获得一定的资源之后，又对其他资源发出请求，但是该资源可能被其他进程占有，此事请求阻塞，但又对自己获得的资源保持不放
 * 不可剥夺条件：是指进程已获得的资源，在未完成使用之前，不可被剥夺，只能在使用完后自己释放
 * 环路等待条件：是指进程发生死锁后，若干进程之间形成一种头尾相接的循环等待资源关系
 *
 */
public class DeadLock {
    static final Object LOCK_A = new Object();
    static final Object LOCK_B = new Object();

    public static void main(String[] args) {
        new Thread3().start();
        new Thread4().start();
    }

    static void sleep1s() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Thread3 extends Thread {

    public void run() {
        System.out.println("Thread-1: try get lock A...");
        synchronized (Main.LOCK_A) {
            System.out.println("Thread-1: lock A got.");
            Main.sleep1s();
            System.out.println("Thread-1: try get lock B...");
            synchronized (Main.LOCK_B) {
                System.out.println("Thread-1: lock B got.");
                Main.sleep1s();
            }
            System.out.println("Thread-1: lock B released.");
        }
        System.out.println("Thread-1: lock A released.");
    }
}

class Thread4 extends Thread {

    public void run() {
        System.out.println("Thread-2: try get lock B...");
        synchronized (Main.LOCK_B) {
            System.out.println("Thread-2: lock B got.");
            Main.sleep1s();
            System.out.println("Thread-2: try get lock A...");
            synchronized (Main.LOCK_A) {
                System.out.println("Thread-2: lock A got.");
                Main.sleep1s();
            }
            System.out.println("Thread-2: lock A released.");
        }
        System.out.println("Thread-2: lock B released.");
    }
}
