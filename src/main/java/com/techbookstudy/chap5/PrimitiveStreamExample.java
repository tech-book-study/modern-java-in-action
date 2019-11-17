package com.techbookstudy.chap5;

import com.techbookstudy.chap4.Dish;

import java.util.OptionalInt;

public class PrimitiveStreamExample {
    public static void main(String[] args) {
        // 사용 불가 코드 -> Stream<Integer> 에서 sum을 할 수 없음.
//        Dish.MENU.stream()
//                .map(Dish::getCalories)
//                .sum();

        int sum = Dish.MENU.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        OptionalInt max = Dish.MENU.stream()
                .mapToInt(Dish::getCalories)
                .max();
    }
}
