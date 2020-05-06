package WaitAndNotify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 生产者消费者问题
 * 通过 sychronized 、nitify 、wait 实现
 * 五个线程 循环消费 任务队列。
 * 一个线程 向任务队列里面放置 十个任务。
 *
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue q = new TaskQueue();
        List<Thread> ts = new ArrayList<Thread>();
        for (int i=0; i<5; i++) {
            Thread t = new Thread() {
                public void run() {
                    // 执行task:
                    while (true) {
                        try {
                            String s = q.getTask();
                            System.out.println("execute task: " + s);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            };
            t.start();
            ts.add(t);
        }
        Thread add = new Thread(() -> {
            for (int i=0; i<10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try { Thread.sleep(100); } catch(InterruptedException e) {}
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);

        //退出所有线程，否则while循环会一直执行
        for (Thread t : ts) {
            t.interrupt();
            System.out.println(t.getName() + "状态：" + t.getState());
        }
    }
}

class TaskQueue {
    Queue<String> queue = new LinkedList<String>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("等待中。。。");
            this.wait();
        }
        return queue.remove();
    }
}

