package com.dongzj.stream.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 缩减操作
 * <p>
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2019/3/18
 * Time: 16:37
 */
public class StreamReduce {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(6);
        list.add(1);
        list.add(5);
        list.add(2);

        Optional<Integer> sum = list.stream().reduce((a, b) -> a + b);
        if (sum.isPresent()) {
            //21
            System.out.println("List的总和为：" + sum.get());
        }

        Integer sum2 = list.stream().reduce(1, (a, b) -> a + b);
        //22
        System.out.println("List的总和为：" + sum2);

        Optional<Integer> product = list.stream().reduce((a, b) -> (a * b));
        if (product.isPresent()) {
            //720
            System.out.println("List的积为：" + product.get());
        }

        Integer product2 = list.stream().reduce(2, (a, b) -> (a * b));
        //1440
        System.out.println("List的积为：" + product2);
    }
}
