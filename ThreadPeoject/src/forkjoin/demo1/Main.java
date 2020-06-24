package forkjoin.demo1;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;


/**
 * @Author: yetianye
 * @CreateTime: 2020-06-24 16:33
 * fork/join
 *  一个大的计算任务0~2000首先分裂为两个小任务0~1000和1000~2000，这两个小任务仍然太大，
 *  继续分裂为更小的0~500，500~1000，1000~1500，1500~2000，最后，计算结果被依次合并，得到最终结果。
 *
 */
public class Main {
    public static void main(String[] args) {
        long[] array = new long[2000];
        long expectedSum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = random();
            expectedSum += array[i];
        }
        System.out.println("Expected sum: " + expectedSum);

        // fork/join:
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);

        Long result = ForkJoinPool.commonPool().invoke(task);//计算任务

        System.out.println(result);
    }

    static Random random = new Random(0);

    static long random() {
        return random.nextInt(100);
    }

}


