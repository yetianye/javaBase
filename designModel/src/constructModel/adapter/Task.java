package constructModel.adapter;

import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-29 11:17
 *
 * 将一个类的接口转换成客户希望的另外一个接口，
 * 使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 *
 * 实现目标接口，这里是Runnable；
 * 内部持有一个待转换接口的引用，这里是通过字段持有Callable接口；
 * 在目标接口的实现方法内部，调用待转换接口的方法。
 */
public class Task implements Callable {
    private long num;
    public Task(long num) {
        this.num = num;
    }
    @Override
    public Object call() throws Exception {
        long r = 0;
        for (long n = 1; n <= this.num; n++) {
            r = r + n;
        }
        System.out.println("Result: " + r);
        return r;
    }
}

class main{
    public static void main(String[] args) {
        Callable<Long> callable = new Task(123450000L);
        Thread thread = new Thread(new RunnableAdapter(new Task(100)));

        //InputStreamReader 就是Java标准库提供的Adapter

    }
}

//适配器
class RunnableAdapter implements Runnable{

    private Callable callable;

    public RunnableAdapter(Callable callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            this.callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
