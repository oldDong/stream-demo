package com.dongzj.stream.function;

import java.util.ArrayList;
import java.util.List;

/**
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2019/3/18
 * Time: 11:32
 */
public class StreamFilter {

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

        //过滤
        System.out.println("过滤List流，只剩下那些大于0并且小于4的元素：");
        list.stream().filter(elem -> elem > 0).filter(elem -> elem < 4).sorted(Integer::compareTo).forEach(System.out::print);

        System.out.println("原List里面的数据：");
        for (Integer elem : list)
            System.out.print(elem + " ");
    }
}
