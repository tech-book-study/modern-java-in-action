package com.techbookstudy.chap2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        arrayForEach(integers, integer -> System.out.println("print ... " + integer));

        // String 리스트를 인수로 받아 각 String 의 길이를 포함하는 Integer 리스트로 변환하는 map 메서드 정의
        List<String> strings = Arrays.asList("hello", "hi", "jay");
        List<Integer> integerLists = map(strings, String::length);
        integerLists.forEach(System.out::println);
    }

    public static <T, R> List<R> map(List<T> array, Function<T, R> function) {
        List<R> list = new ArrayList<>();
        for (T t : array) {
            R apply = function.apply(t);
            list.add(apply);
        }
        return list;
    }

    public static <T> void arrayForEach(List<T> array, Consumer<T> consumer) {
        for (T t : array) {
            consumer.accept(t);
        }
    }
}
