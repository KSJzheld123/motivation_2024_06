package org.koreait;

import java.util.Scanner;

public class Container {
    private static Scanner sc;

    public static void init() {
        sc = new Scanner(System.in);
    }
    // 공유 자원을 모아두는 공간 자원 해제
    public static void close() {
        sc.close();
    }

    public static Scanner getScanner() {
        return sc;
    }
}
