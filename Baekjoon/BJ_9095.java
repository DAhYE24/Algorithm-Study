package Baekjoon;

import java.util.*;

public class BJ_9095 {
    // https://www.acmicpc.net/problem/9095

    public static void main_9095() {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();

            int[] memo = new int[n + 1];
            memo[0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 3; j > 0; j--) {
                    if (i - j >= 0) memo[i] += memo[i - j];
                }
            }

            System.out.println(memo[n]);
        }
    }
}
