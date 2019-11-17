package com.techbookstudy.chap5;

import com.techbookstudy.chap4.Dish;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
        int sum = 0;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);

        // using reduce
        Integer result = numbers.stream().reduce(0, Integer::sum);
        System.out.println(result);

        Integer count = Dish.MENU.stream()
                .map(dish -> 1)
                .reduce(0, Integer::sum);
        System.out.println(count);
    }
}
