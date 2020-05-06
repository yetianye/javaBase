package DeadLock;

/**
 *  死锁
 *  两个线程各自持有不同的锁，然后各自试图获取对方手里的锁，造成了双方无限等待下去，这就是死锁。
 *  1.线程1先获取A锁，线程2先获取B锁，
 *  2.线程1要获取B锁，线程2要获取A锁，但是a锁、和b锁没有释放。
 *  3.导致死锁
 *  4.正确方法，改变获取锁的顺寻，线程1 和线程2 都先获取A锁，这样，其中一个线程先释放A锁，另一个线程就可以获取A锁了。
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
