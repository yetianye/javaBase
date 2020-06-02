package Volatile;

/**
 *  通过锁 来实现线程可见性
 */
public class Demo1 {
    public static void main(String[] args) {
        Task task = new Task();
        task.start();

        while (true){
            /*if(task.isTag()){
                System.out.println("有啥东西");
            }*/

            /**
             *  通过加锁解决线程变量可见性问题
             */
            synchronized (task){
                if(task.isTag()){
                    System.out.println("有啥东西");
                }
            }
        }
    }

}

class Task extends Thread{
    private boolean tag = false;

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
