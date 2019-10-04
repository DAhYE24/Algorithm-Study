package Baekjoon;

import java.util.*;

public class BJ_11057 {
    private static final long MOD = 10007;

    public static void main_11057() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[][] dp = new long[n + 1][10];
        for (int i = 0; i <= 9; i++) {  // 한 자릿수일 때 Memorization 값
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int x = 0; x <= j; x++) {
                    dp[i][j] += dp[i - 1][x];
                    dp[i][j] %= MOD;
                }
            }
        }

        int cnt = 0;
        for (int j = 0; j <= 9; j++) {
            cnt += dp[n][j];
        }
        System.out.println(cnt % MOD);
    }
}
