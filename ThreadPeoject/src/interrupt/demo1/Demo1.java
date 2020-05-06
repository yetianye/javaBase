package interrupt.demo1;


/**
 *  interrupt 是中断线程
 *  isInterrupted 中断状态
 *
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new yeThread();
        t.start();
        Thread.sleep(1); // 暂停1毫秒
        System.out.println("中断状态：" + t.isInterrupted());
        t.interrupt(); // 中断t线程
        System.out.println("中断状态：" + t.isInterrupted());
        //t.join(); // 等待t线程结束
        System.out.println("end");
    }
}

/**
 * isInterrupted() 判断线程中断状态
 */
class yeThread extends Thread {
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n ++;
            System.out.println(n + " hello!");
        }
    }
}