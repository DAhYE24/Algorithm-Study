package Baekjoon;

import java.util.*;

public class BJ_2667 {
    // https://www.acmicpc.net/problem/2667

//    private static int[][] arr;
//    private static boolean[][] chk;
//
//    public static void main_2667() {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        // 저장 요소
//        arr = new int[n][n];
//        chk = new boolean[n][n];
//        ArrayList<Integer> outputs = new ArrayList<Integer>(); // 오름차순으로 출력하기
//
//        // 이차원배열로 저장
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
//
//
//        int cnt = 0;
//        for (int row = 0; row < n; row++) {
//            for (int col = 0; col < n; col++) {
//                if (!chk[row][col] && arr[row][col] > 0) {
//                    if (!chk[row][col] && arr[row][col] > 0) {
//                        bfs(row, col);
//                        cnt;
//                    }
//                }
//            }
//        }
//    }
//
//    private static void bfs(int row, int col) {
//        Queue<Integer> rowQue = new LinkedList<Integer>();
//        Queue<Integer> colQue = new LinkedList<Integer>();
//        chk[row][col] = true;
//
//        rowQue.add(row);
//        colQue.add(col);
//
//        while(!rowQue.isEmpty() && !colQue.isEmpty()){
//            int tmpRow = rowQue.remove();
//            int tmpCol = colQue.remove();
//
//            if(!chk[tmpRow-1][tmpCol]){
//
//            }
//        }
//    }
}
