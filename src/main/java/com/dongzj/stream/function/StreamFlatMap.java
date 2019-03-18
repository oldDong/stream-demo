package com.dongzj.stream.function;

import java.util.Arrays;
import java.util.List;

/**
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2019/3/18
 * Time: 17:10
 */
public class StreamFlatMap {

    public static void main(String[] args) {
        List<String> cities = Arrays.asList("GuangZhou ShangHai", "GuangZhou ShenZhen", "ShangHai ShenZhen", "BeiJing ShangHai", "GuangZhou BeiJing", "ShenZhen BeiJing");

        //打印数组对应的地址
        cities.stream().map(city -> Arrays.stream(city.split(" "))).forEach(System.out::println);
        System.out.println();

        //流里面的元素还是一个数组
        cities.stream().map(city -> Arrays.stream(city.split(" ")))
                .forEach(mCity -> cities.forEach(city -> System.out.print(city + " ")));

        System.out.println();

        //直接一个flatMap()就把数组合并到映射流里面了
        cities.stream().flatMap(city -> Arrays.stream(city.split(" "))).forEach(System.out::println);
        System.out.println();

        //使用distinct方法去重
        cities.stream().flatMap(city -> Arrays.stream(city.split(" "))).distinct().forEach(System.out::println);
    }
}
