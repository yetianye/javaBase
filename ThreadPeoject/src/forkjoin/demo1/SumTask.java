package forkjoin.demo1;

import java.util.concurrent.RecursiveTask;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-24 16:37
 */
public class SumTask extends RecursiveTask {

    private final int threshold = 500;
    private long array[];
    private int start;
    private int end ;

    public SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }


    @Override
    protected Object compute() {
        if(end - start <= threshold){
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += this.array[i];
            }
            return sum;
        }else {
            //拆分任务
            int middle = (end + start) / 2 ;
            System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
            SumTask sumTask1 = new SumTask(this.array, start, middle);
            SumTask sumTask2 = new SumTask(this.array,middle,end);
            invokeAll(sumTask1,sumTask2);
            Long subresult1 = (Long) sumTask1.join();
            Long subresult2  = (Long) sumTask2.join();
            Long result = subresult1 + subresult2;
            return result;
        }
    }
}
