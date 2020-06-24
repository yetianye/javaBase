package ThreadLocal.demo5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-24 15:53
 *
 * 通过AutoCloseable接口配合try (resource) {...}结构，让编译器自动为我们关闭资源
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(3);
        String[] users = new String[] { "Bob", "Alice", "Tim", "Mike", "Lily", "Jack", "Bush" };
        for (String user : users) {
            es.submit(new Task(user));
        }
        es.awaitTermination(3, TimeUnit.SECONDS);
        es.shutdown();
    }
}

class Task implements Runnable {

    final String username;

    public Task(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        //将资源 try 起来，{} 调用结束后会被回收
        //当前线程执行完相关代码后，很可能会被重新放入线程池中
        try (UserContext ctx = new UserContext(this.username)) {
            new Task1().process();
            new Task2().process();
            new Task3().process();
        }
    }
}



