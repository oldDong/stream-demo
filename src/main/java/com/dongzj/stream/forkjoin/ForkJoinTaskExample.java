package com.dongzj.stream.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author dongzj
 * @date 2020/10/10 14:46
 */
public class ForkJoinTaskExample extends RecursiveTask<Integer> {

    private static final int threadhold = 2;

    private int start;

    private int end;

    public ForkJoinTaskExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= threadhold;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (start + end ) / 2;
            ForkJoinTaskExample leftTask = new ForkJoinTaskExample(start, middle);
            ForkJoinTaskExample rightTask = new ForkJoinTaskExample(middle + 1, end);

            // 执行子任务
            leftTask.fork();
            rightTask.fork();

            // 等待任务执行结束合并结果
            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinTaskExample task = new ForkJoinTaskExample(1, 100);

        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println("result: " + result.get());
        } catch(Exception e) {
            System.out.println("exception: " + e);
        }
    }
}
