package com.dongzj.stream.function;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取流中的最大值
 * <p>
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2019/3/18
 * Time: 10:11
 */
public class StreamMax {

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

        //最大值
        System.out.println("List中的最大值：");
        list.stream().max(Integer::compareTo).ifPresent(System.out::println);
    }
}
