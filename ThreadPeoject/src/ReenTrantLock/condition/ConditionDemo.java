package ReenTrantLock.condition;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过 ReenterLock 实现
 * 五个线程 循环消费 任务队列。
 * 一个线程 向任务队列里面放置 十个任务。
 */
public class ConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        //任务队列
        TaskQueue queueTask = new TaskQueue();
        List<Thread> costThread = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    //线程里面循环要 判断是否线程状态，否者会死循环
                    while(true){
                        String task = null;
                        try {
                            task = queueTask.getTask();
                        } catch (InterruptedException e) {
                            return; //中断
                        }
                        System.out.println(Thread.currentThread().getName() + "获取任务:"+task+",任务数量："+queueTask.getSize());
                    }
                }
            };
            thread.start();
            costThread.add(thread);
        }

        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                double name = Math.random();
                System.out.println("添加 ： t-" + name+",任务数量："+queueTask.getSize());
                queueTask.addTask("t-" + name);
            }
        });

        add.start();
        //程执行结束
        add.join();

        Thread.sleep(500);

        for (Thread t : costThread){
            t.interrupt();
            System.out.println(t.getName() + "状态：" + t.getState());
        }

    }
}


class TaskQueue {
    private Queue queue = new LinkedList<String>();
    private final  Lock lock  = new ReentrantLock();
    private final Condition condition = lock.newCondition();//condition对象

    //添加
    public void  addTask(String task){
        lock.lock();
        try {
            queue.add(task);
            condition.signalAll();//唤醒
        } finally {
            lock.unlock();
        }
    }

    //删除
    public String getTask() throws InterruptedException {
        lock.lock();
        try{
            while(queue.isEmpty()){
                condition.await(); //线程释放锁，等待状态
                System.out.println("获取任务等待中。。。。");
            }
            return queue.remove().toString();
        } finally {
            lock.unlock();
        }
    }

    public int getSize(){
        return queue.size();
    }

}