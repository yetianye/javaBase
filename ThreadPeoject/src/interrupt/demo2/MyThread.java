package interrupt.demo2;

public class MyThread extends Thread {
    public void run() {
        System.out.println("MyThread开始");
        Thread hello = new HelloThread();
        hello.start(); // 启动hello线程
        try {
            hello.join(); // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        hello.interrupt();
        System.out.println("MyThread--结束");
    }
}
