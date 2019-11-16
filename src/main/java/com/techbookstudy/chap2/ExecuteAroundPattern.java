package com.techbookstudy.chap2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAroundPattern {
    public static void main(String[] args) throws IOException {
        String result = processFile2(BufferedReader::readLine);
        System.out.println(result);
    }

    // 1단계
    public static String processFile1() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    // 2단계
    public static String processFile2(Process p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

    @FunctionalInterface
    interface Process {
        String process(BufferedReader br) throws IOException;
    }
}
