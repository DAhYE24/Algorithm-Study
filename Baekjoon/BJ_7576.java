package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class BJ_7576 {
    private static int[] calRow = {-1, 1, 0, 0};
    private static int[] calCol = {0, 0, -1, 1};

    public static void main_7576() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 가로 2<= <= 1000
        int n = sc.nextInt(); // 세로 2<= <= 1000
        int[][] box = new int[n][m];
        int[][] days = new int[n][m];

        // 토마토 정보 배열
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                box[i][j] = sc.nextInt();
//            }
//        }

        // 익은 토마토 위치 찾기
        Queue<Pair> que = new LinkedList<Pair>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = sc.nextInt(); // [Caution] 토마토 상태 체크하면서 다른 값도 체크
                days[i][j] = -1;
                if (box[i][j] == 1) {
                    que.add(new Pair(i, j));
                    days[i][j] = 0;
                }
            }
        }

        // BFS 탐색
        while (!que.isEmpty()) {
            Pair pair = que.remove();
            int startRow = pair.x;
            int startCol = pair.y;

            for (int i = 0; i < 4; i++) {
                int tmpRow = startRow + calRow[i];
                int tmpCol = startCol + calCol[i];

                if (tmpRow >= 0 && tmpCol >= 0 && tmpRow < n && tmpCol < m
                        && days[tmpRow][tmpCol] == -1 && box[tmpRow][tmpCol] == 0) {
                    que.add(new Pair(tmpRow, tmpCol));
                    days[tmpRow][tmpCol] = days[startRow][startCol] + 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (days[i][j] > cnt) cnt = days[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (days[i][j] == -1 && box[i][j] == 0) {
                    cnt = -1;
                }
            }
        }

        System.out.println(cnt);
    }
}
