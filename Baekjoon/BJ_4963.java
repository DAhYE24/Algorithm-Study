package Baekjoon;

import java.util.*;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BJ_4963 {
    // https://www.acmicpc.net/problem/4963

    private static int[][] arr;
    private static boolean[][] chk;

    public static void main_4963() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int w = sc.nextInt(); // 열
            int h = sc.nextInt(); // 행
            if (w == 0 && h == 0) break;
            sc.nextLine();

            // 인접행렬 생성
            arr = new int[h][w];
            chk = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                String[] tmpStr = sc.nextLine().split("\\s");
                for (int j = 0; j < tmpStr.length; j++) {
                    arr[i][j] = Integer.parseInt(tmpStr[j]);
                }
            }

            // BFS 사용해서 연결 요소 확인하기
            int cnt = 0;
            for (int x = 0; x < h; x++) {
                for (int y = 0; y < w; y++) {
                    if (arr[x][y] == 1 && !chk[x][y]) {
                        bfs(x, y, h, w);
                        ++cnt;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void bfs(int row, int col, int h, int w) {
        Queue<Pair> que = new LinkedList<Pair>();
        que.add(new Pair(row, col));
        chk[row][col] = true;

        while (!que.isEmpty()) {
            Pair tmpPair = que.remove();
            int tmpRow = tmpPair.x;
            int tmpCol = tmpPair.y;

            for (int i = tmpRow - 1; i <= tmpRow + 1; i++) {
                for (int j = tmpCol - 1; j <= tmpCol + 1; j++) {
                    if (i >= 0 && j >= 0 && i < h && j < w && arr[i][j] == 1 && !chk[i][j]) {
                        que.add(new Pair(i, j));
                        chk[i][j] = true;
                    }
                }
            }
        }
    }
}
