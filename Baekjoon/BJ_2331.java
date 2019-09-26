package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_2331 {
    // https://www.acmicpc.net/problem/2331

    public static void main_2331() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(sc.nextInt());
        int p = sc.nextInt();

        boolean flag = false;

        while (!flag) {
            int formerNum = arr.get(arr.size() - 1);
            int numLen = (int) (Math.log10(formerNum) + 1);

            // D[n-1]의 각 자리 수를 p번 곱한 수들의 합
            int curNum = 0;
            for (int i = numLen; i > 0; i--) {
                int tmp = (int) (formerNum / Math.pow(10, i - 1));
                formerNum -= (int) tmp * Math.pow(10, i - 1);
                curNum += (int) Math.pow(tmp, p);
            }
            arr.add(curNum);

            // 수열 항목에 중복되는 위치가 있는지 확인하기
            for (int j = 0; j < arr.size() - 1; j++) {
                if (arr.get(j) == curNum) {
                    System.out.println(j);
                    flag = true;
                    break;
                }
            }
        }
    }

    public static int[] chk = new int[1000000];

    public static void main_2331_bj() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(length(a, p, 1));
    }

    private static int length(int a, int p, int cnt) {
        if (chk[a] != 0) return chk[a] - 1;

        chk[a] = cnt;
        int b = next(a, p);
        return length(b, p, cnt + 1);
    }


    private static int next(int a, int p) {
        int ans = 0;
        while (a > 0) {
            ans += pow(a % 10, p); // 자릿수마다 값 도출하여 모두 더함
            a /= 10;
        }

        return ans;
    }

    private static int pow(int x, int p) { // p번 곱하게 함
        int num = 1;
        for (int i = 0; i < p; i++) {
            num = num * x;
        }

        return num;
    }
}
