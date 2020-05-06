package interrupt.demo3;

/**
 * 通过running 中断线程
 */
public class Running {
    public static void main(String[] args) {
        HelloThread t = new HelloThread();
        t.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("主线程中断！！");
        }
        t.running = false; // 标志位置为false
    }
}

/**
 * volatile 线程间共享的变量，确保每个线程都能读取到更新后的变量值。
 */
class HelloThread extends Thread {
    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}