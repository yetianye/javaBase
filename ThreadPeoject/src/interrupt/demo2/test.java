package interrupt.demo2;

public class test {

    /**
     *  1. 当t线程中断之后，t线程中hello.join(); 会报中断异常。但是并不会中断hello线程
     *  2.t线程中 ，调用interrupt()才会中断 hello线程
     *
     *  main线程通过调用t.interrupt()从而通知t线程中断，而此时t线程正位于hello.join()的等待中，此方法会立刻结束等待并抛出InterruptedException。
     *  由于我们在t线程中捕获了InterruptedException， 因此，就可以准备结束该线程。
     *  在t线程结束前，对hello线程也进行了interrupt()调用通知其中断。如果去掉这一行代码，可以发现hello线程仍然会继续运行，且JVM不会退出。
     *
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");

    }
}
