package baekJoon;
import java.util.Scanner;

public class BJ_11052 {
	// https://www.acmicpc.net/problem/11052

	public static void main_11052() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 카드 배열 만들기
		int[] cardArr = new int[n + 1];
		int[] maxCardNum = new int[n + 1];
		for (int i = 0; i < n; i++) {
			cardArr[i + 1] = sc.nextInt();
		}

		// 최대 구하는 방법(반복문 사용하기)
		for (int i = 1; i <= n; i++) {
			maxCardNum[i] = cardArr[i];

			for (int j = 1; j <= i; j++) {
				int tmp = maxCardNum[i - j] + cardArr[j];
				if (tmp > maxCardNum[i])
					maxCardNum[i] = tmp;
			}
		}

		System.out.println(maxCardNum[n]);
	}
}
