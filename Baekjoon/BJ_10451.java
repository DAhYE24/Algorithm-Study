package Baekjoon;

import java.util.Scanner;

public class BJ_10451 {
    // https://www.acmicpc.net/problem/10451

    public static void main_10451() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // [Caution] 정답 바로 출력해도 됨
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            boolean[] chk = new boolean[n + 1];

            for (int j = 1; j <= n; j++) { // 배열 안에 값 저장해두기
                arr[j] = sc.nextInt();
            }

            int cnt = 0;
            for (int x = 1; x <= n; x++) {
                if (!chk[x]) { // [Caution] 반복할 때 chk 상태 확인하기
                    dfs(arr, chk, x);
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }

    private static void dfs(int[] arr, boolean[] chk, int start) {
        if (chk[start]) return;
        chk[start] = true;
        dfs(arr, chk, arr[start]);
    }
}