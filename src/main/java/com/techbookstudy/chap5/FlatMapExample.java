package com.techbookstudy.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hello", "World");
        List<String[]> result = strings.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        // 이런식이면 문자 하나하나가 아니라 String[] 의 Stream 이 생겨서 통짜로 collect 가 됩니다.

        List<String> result2 = strings.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        result2.forEach(System.out::println);
    }
}
