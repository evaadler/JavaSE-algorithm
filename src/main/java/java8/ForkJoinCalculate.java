package java8;

import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinCalculate
 *
 * @author Alicia
 * @description
 * @date 2020/6/29
 */
public class ForkJoinCalculate extends RecursiveTask<Long>{

    private long start;
    private long end;

    // 临界值
    private static final long THRESHOLD = 10000;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD){
            long sum = 0;
            for (long i=0; i<=end; i++){
                sum += i;
            }
            return sum;
        }else{
            long middle = (start + end) / 2;
            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            left.fork(); // 拆分子任务，同时押入线程队列

            ForkJoinCalculate right = new ForkJoinCalculate(middle+1, end);
            right.fork(); // 拆分子任务，同时押入线程队列

            return left.join() + right.join();

        }

    }
}
