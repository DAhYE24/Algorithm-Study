package Baekjoon;

import java.util.Scanner;

public class BJ_11727 {
    public static void main_11727() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;

            for (int i = 2; i <= n; i++) {
                arr[i] = arr[i - 1] + (2 * arr[i - 2]);
                arr[i] %= 10007;
            }

        System.out.println(arr[n]);
    }
}
