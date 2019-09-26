package Baekjoon;

import java.util.Scanner;

public class BJ_11726 {
    // https://www.acmicpc.net/problem/11726

    private static int[] arr;

    public static void main_11726() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n + 1];

        System.out.println(getRectMthdNum(n));
    }

    // Top-Down 보다는 Bottom-Up이 더 효율적이다
    private static int getRectMthdNum(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (arr[n] > 0) return arr[n];

        arr[n] = getRectMthdNum(n - 1) + getRectMthdNum(n - 2);

        return arr[n] % 10007;
    }
}
