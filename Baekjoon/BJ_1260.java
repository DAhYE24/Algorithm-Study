package Baekjoon;

import java.util.*;

public class BJ_1260 {
    private static boolean[] chk;
    private static ArrayList<Integer>[] graphArr;

    public static void main_1260() {
        Scanner sc = new Scanner(System.in);

        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        int start = sc.nextInt();

        // 인접 리스트 만들기
        chk = new boolean[vertex + 1];
        graphArr = (ArrayList<Integer>[]) new ArrayList[vertex + 1];
        for (int i = 1; i <= vertex; i++) { // 각 배열 요소도 초기화 작업 진행하기
            graphArr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edge; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graphArr[a].add(b);
            graphArr[b].add(a);
        }

        for (int i = 1; i <= vertex; i++) { // 테스트케이스 문제 풀어보니 정렬이 필요함
            Collections.sort(graphArr[i]);
        }

        dfs(start);
        System.out.println();
        Arrays.fill(chk, false);
        bfs(start);
    }


    public static void dfs(int start) {
        if (chk[start]) { // [백준 코드 참고] true인 경우는 아예 return
            return;
        }


        chk[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < graphArr[start].size(); i++) {
            int y = graphArr[start].get(i);

            if (!chk[y]) {
                dfs(y);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<Integer>();
        chk[start] = true;
        que.add(start);

        while (!que.isEmpty()) {
            int y = que.remove();
            System.out.print(y + " ");

            for (int i = 0; i < graphArr[y].size(); i++) {
                int tmp = graphArr[y].get(i);
                if (!chk[tmp]) {
                    chk[tmp] = true;
                    que.add(tmp);
                }
            }
        }
    }
}
