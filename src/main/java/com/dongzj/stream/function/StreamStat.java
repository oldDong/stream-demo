package com.dongzj.stream.function;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * 统计
 * <p>
 * Author: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2019/4/24
 * Time: 10:28
 */
public class StreamStat {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 2, 4, 5, 5, 8, 9);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("max: " + stats.getMax());
        System.out.println("min: " + stats.getMin());
        System.out.println("avg: " + stats.getAverage());
        System.out.println("sum: " + stats.getSum());
        System.out.println("count: " + stats.getCount());
    }
}
