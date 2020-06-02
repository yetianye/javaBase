package ThreadPool.future;


import java.util.concurrent.*;

/**
 * excute 和 submit 区别
 * Java标准库还提供了一个Callable接口，和Runnable接口比，它多了一个返回值：
 * 们在主线程某个时刻调用Future对象的get()方法，就可以获得异步执行的结果。
 * 在调用get()时，如果异步任务已经完成，我们就直接获得结果。如果异步任务还没有完成，那么get()会阻塞，直到任务完成后才返回结果。
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            Future future = executorService.submit(new Task());

            //返回值,get方法会阻塞线程，必须要一个线程返回之后，才会执行下一个线程
            System.out.println(future.get());
        }


    }
}
// 实现Callable接口可以返回值
class Task implements Callable{
    @Override
    public Object call() throws Exception {
        Thread.sleep(3000);
        return Thread.currentThread().getName() + "执行结束";
    }
}

