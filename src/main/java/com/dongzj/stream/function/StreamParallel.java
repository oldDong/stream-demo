package com.dongzj.stream.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 并行流
 * <p>
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2019/3/18
 * Time: 16:45
 */
public class StreamParallel {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(6);
        list.add(1);
        list.add(5);
        list.add(2);

        Optional<Integer> sum = list.parallelStream().reduce((a, b) -> a + b);
        if (sum.isPresent()) {
            //21
            System.out.println("List的总和为：" + sum.get());
        }

        Integer sum2 = list.stream().reduce(1, (a, b) -> a + b);
        //22
        System.out.println("List的总和为：" + sum2);

        Optional<Integer> product = list.stream().reduce((a, b) -> a * b);
        if (product.isPresent()) {
            //720
            System.out.println("List的积为：" + product.get());
        }

        Integer product2 = list.parallelStream().reduce(2, (a, b) -> a * b);
        //46080
        System.out.println("List的积为：" + product2);

        //accumulator:累加器       combiner：合成器
        Integer product3 = list.parallelStream().reduce(1, (a, b) -> a * b, (a, b) -> a * b);
        //720
        System.out.println("List的积为：" + product3);
    }
}
