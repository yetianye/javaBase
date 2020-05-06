package Deamon;

/**
 * 守护线程
 */
public class DeamonThread {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new myRunnable());
        Thread deamonThread = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("老子中断了");
                    e.printStackTrace();
                }
                System.out.println("老子守护中");
            }
        });


        deamonThread.setDaemon(true);//设置守护线程

        thread.start();
        deamonThread.start();

        Thread.sleep(2000);
        thread.interrupt();//子线程结束

        Thread.sleep(2000);
        System.out.println("end");//主线程结束，守护线程也结束
    }
}

class myRunnable implements Runnable{

    @Override
    public void run() {
        int n = 0;
        while(true){
            n++;
            System.out.println(n);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("线程中断了！！！！！！！");
                break;
            }
        }
    }
}
