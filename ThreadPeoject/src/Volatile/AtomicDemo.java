package Volatile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yetianye
 * @CreateTime: 2020-05-13 22:46
 * volatile 使 long double 具有原子性
 */
public class AtomicDemo {
    static volatile long num = 1000000;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList =new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                synchronized (AtomicDemo.class){
                    for (int j = 0; j < 200000; j++) {
                            num--;  //volatile变量不能用 共享变量进行赋值，否者不能保证原子性
                    }
                }
            });
            thread.start();
            threadList.add(thread);
        }

        for (Thread ts : threadList){
            ts.join();
        }

        System.out.println(num);
    }
}
