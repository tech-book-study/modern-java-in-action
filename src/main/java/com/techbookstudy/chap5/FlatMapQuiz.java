package com.techbookstudy.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapQuiz {
    public static void main(String[] args) {
        // 모든 숫자 쌍의 리스트 반환하기
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<Integer[]> results = numbers1.stream()
                .flatMap(num1 -> numbers2.stream()
                        .map(num2 -> new Integer[]{num1, num2}))
                .collect(Collectors.toList());
    }
}
