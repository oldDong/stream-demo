package com.dongzj.stream.function;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

/**
 * 流与迭代器
 * <p>
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2019/3/18
 * Time: 17:28
 */
public class StreamIterator {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        Spliterator<String> spliterator = list.stream().spliterator();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println();

        list.stream().spliterator().forEachRemaining(System.out::println);
    }
}
