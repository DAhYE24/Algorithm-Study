package Baekjoon;

import java.util.Scanner;

public class BJ_9466 {
    // https://www.acmicpc.net/problem/9466

    public static void main_9466() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            boolean[] chk = new boolean[n + 1];

            for (int j = 1; j <= n; j++) {
                arr[j] = sc.nextInt();
            }
        }
    }
}