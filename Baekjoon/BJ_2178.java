package Baekjoon;

import java.util.*;

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class BJ_2178 {
    private static int[][] arr;
    private static int[][] dist;
    private static boolean[][] chk;

    private static int[] calRow = {-1, 1, 0, 0};
    private static int[] calCol = {0, 0, -1, 1};

    public static void main_2718() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n + 1][m + 1];
        dist = new int[n + 1][m + 1];
        chk = new boolean[n + 1][m + 1];
        sc.nextLine();

        // 배열 생성
        for (int i = 1; i <= n; i++) {
            String str = sc.nextLine();
            for (int j = 1; j <= str.length(); j++) {
                arr[i][j] = str.charAt(j - 1) - '0';
            }
        }

        bfs(1, 1, n, m);
        System.out.println(dist[n][m]);
    }

    private static void bfs(int startRow, int startCol, int exitRow, int exitCol) {
        Queue<Pair> que = new LinkedList<Pair>();
        que.add(new Pair(startRow, startCol));
        chk[startRow][startCol] = true;
        dist[startRow][startCol] = 1;

        while (!que.isEmpty()) {
            Pair pair = que.remove();
            startRow = pair.row;
            startCol = pair.col;

            for (int i = 0; i < 4; i++) {
                int tmpRow = startRow + calRow[i];
                int tmpCol = startCol + calCol[i];
                if (tmpRow >= 1 && tmpCol >= 1 && tmpRow <= exitRow && tmpCol <= exitCol
                        && !chk[tmpRow][tmpCol] && arr[tmpRow][tmpCol] == 1) {
                    que.add(new Pair(tmpRow, tmpCol));
                    chk[tmpRow][tmpCol] = true;
                    dist[tmpRow][tmpCol] = dist[startRow][startCol] + 1;
                }
            }
        }
    }
}
