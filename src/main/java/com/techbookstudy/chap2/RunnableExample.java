package com.techbookstudy.chap2;

public class RunnableExample {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello1");
            }
        };
        process(r1);

        Runnable r2 = () -> System.out.println("hello2");
        process(r2);

        process(() -> System.out.println("hello3"));
    }

    public static void process(Runnable r) {
        r.run();
    }
}
