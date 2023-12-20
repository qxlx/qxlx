package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author jiabaobao
 * @date 2023/12/11 2:55 PM
 */
public class ListDemo {

    public static void main(String[] args) {
//        method1();
        method2();
    }

    public static void method1() {
        int [] arr = new int []{1,2,3};
        List asList = Arrays.asList(arr);
        System.out.println(asList+" "+asList.size()+" "+asList.get(0).getClass());
        List<Integer> integerList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(integerList+" "+integerList.size()+" "+integerList.get(0).getClass());

        asList.add(4);
    }

    private static List<List<Integer>> ans = new ArrayList<>();

    public static void method2() {
        for (int i = 0; i < 10000 ; i++) {
            List<Integer> integerList = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
            ans.add(integerList.subList(0,1));
        }
    }

}
