package com.dongzj.stream.function;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 流的映射
 * <p>
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2019/3/18
 * Time: 17:05
 */
public class StreamMap {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(6);
        list.add(1);
        list.add(5);
        list.add(2);

        //使用并行流来处理
        Integer product = list.parallelStream().reduce(1, (a, b) -> a * (b * 2), (a, b) -> a * b);
        //46080
        System.out.println("product: " + product);

        //使用映射来处理
        Stream<Integer> productNewMapStream = list.parallelStream().map(a -> a * 2);
        Integer productMap = productNewMapStream.reduce(1, (a, b) -> a * b);
        //46080
        System.out.println("productMap: " + productMap);
    }
}
