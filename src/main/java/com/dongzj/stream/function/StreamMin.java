package com.dongzj.stream.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 获取流中的最小值
 * <p>
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2019/3/18
 * Time: 10:07
 */
public class StreamMin {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(6);
        list.add(1);
        list.add(5);
        list.add(2);

        System.out.println("List中的数据：");
        for (Integer elem : list)
            System.out.print(elem + " ");
        System.out.println();

        //最小值
        System.out.println("List中最小值：");
        Stream<Integer> stream = list.stream();
        Optional<Integer> min = stream.min(Integer::compareTo);
        if (min.isPresent()) {
            System.out.println(min.get());
        }
    }
}
