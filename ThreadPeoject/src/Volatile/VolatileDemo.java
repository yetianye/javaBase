package Volatile;

/**
 * @Author: yetianye
 * @CreateTime: 2020-05-13 22:21
 * volatile 实现线程可见性
 */
public class VolatileDemo {
    public static void main(String[] args) {

        Task2 a = new Task2();
        a.start();

        while(true){
            if(a.isTag()){
                System.out.println("你看见我啦");
            }
        }
    }
}


class Task2 extends Thread{
    private volatile boolean tag = false;

    public Boolean isTag(){
        return this.tag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tag = true;
        System.out.println("tag :" + tag);
    }
}
