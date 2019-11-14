package com.techbookstudy.chap2;

import java.util.Arrays;
import java.util.List;

public class Quiz {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, FilteringApples.Color.GREEN),
                new Apple(155, FilteringApples.Color.GREEN),
                new Apple(120, FilteringApples.Color.RED));
        prettyPrintApple(inventory, apple -> apple.getWeight() + "g 입니다");
    }

    public interface AppleFormatter {
        String accept(Apple apple);
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter appleFormatter) {
        for (Apple apple : inventory) {
            System.out.println(appleFormatter.accept(apple));
        }
    }

    static class Apple {
        private int weight = 0;
        private FilteringApples.Color color;

        public Apple(int weight, FilteringApples.Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public FilteringApples.Color getColor() {
            return color;
        }

        public void setColor(FilteringApples.Color color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color=%s, weight=%d}", color, weight);
        }
    }
}
