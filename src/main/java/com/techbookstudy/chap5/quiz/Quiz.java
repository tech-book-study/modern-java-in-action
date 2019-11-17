package com.techbookstudy.chap5.quiz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Quiz {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Q1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리
        List<Transaction> answer1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
        answer1.forEach(System.out::println);
        System.out.println();

        // Q2. 거래자가 근무하는 모든 도시를 중복 없이 나열
        List<String> answer2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        answer2.forEach(System.out::println);
        System.out.println();

        // Q3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬
        List<Trader> answer3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        answer3.forEach(System.out::println);
        System.out.println();

        // Q4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환
        String answer4 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .reduce("", (name1, name2) -> name1 + " " + name2);
        System.out.println(answer4);

        String answer4Opt = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .collect(Collectors.joining(" "));
        System.out.println(answer4Opt);
        System.out.println();

        // Q5. 밀라노에 거래자가 있는지
        boolean answer5 = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(answer5);
        System.out.println();

        // Q6. 케임브리지에 거주하는 거래자의 모든 트랜잭션 값 출력
        List<Integer> answer6 = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
        answer6.forEach(System.out::println);
        System.out.println();

        // Q7. 전체 트랜잭션 중 최댓값
        Integer answer7 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .orElse(-1);
        System.out.println(answer7);

        // Q8. 전체 트랜잭션 중 최솟값
        Integer answer8 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .orElseThrow(RuntimeException::new);
        System.out.println(answer8);

        // 이것도 가능
        Optional<Transaction> min = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue));
    }
}
