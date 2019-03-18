package com.dongzj.stream.function;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 对流中的数据进行排序
 * <p>
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2019/3/18
 * Time: 10:13
 */
public class StreamSort {

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

        //排序
        System.out.println("将List流进行排序：");
        Stream<Integer> sorted = list.stream().sorted();
        sorted.forEach(elem -> System.out.print(elem + " "));
        System.out.println();
    }
}
