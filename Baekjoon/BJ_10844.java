package Baekjoon;

import java.util.*;

public class BJ_10844 {
    private static final long MOD = 1000000000L;

    public static void main_10844() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n + 1][10];

        // 자릿수 1인 경우
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {

                if (j - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }

                if (j + 1 <= 9) {
                    dp[i][j] += dp[i - 1][j + 1];
                }

                dp[i][j] %= MOD;
            }
        }

        int cnt = 0;
        for (int i = 0; i <= 9; i++) {
            cnt += dp[n][i];
        }

        System.out.println(cnt % MOD);
    }
}
