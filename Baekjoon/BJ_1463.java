package Baekjoon;

import java.util.Scanner;

public class BJ_1463 {
    // https://www.acmicpc.net/problem/1463
    // Top-Down 방식

    private static int[] arr;

    public static void main_1463() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n + 1];
        arr[2] = 1;

        System.out.println(getMinNum(n));
    }

    private static int getMinNum(int n) {
        if (n == 1) return 0;
        if (arr[n] > 0) return arr[n];

        arr[n] = getMinNum(n - 1) + 1;

        if (n % 2 == 0) {
            int tmp = getMinNum(n / 2) + 1;
            if (arr[n] > tmp) arr[n] = tmp;
        }

        if (n % 3 == 0) {
            int tmp = getMinNum(n / 3) + 1;
            if (arr[n] > tmp) arr[n] = tmp;
        }

        return arr[n];
    }
}
