package com.mystudy.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public int numEnclaves(int[][] A) {
        if (null == A || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int row = A.length;
        int col = A[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<Integer> queue = new LinkedList<>();

        int total = 0;
        int visitCnt = 0;
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (i == 0 || j == 0 || i == row -1 || j == col - 1) {
                    visited[i][j] = true;
                    if (A[i][j] == 1) {
                        visitCnt ++;

                        queue.add(i * row + j);
                    }
                }
                if (A[i][j] == 1) {
                    total ++;
                }
            }
        }
        int[][] directions = {{0,1}, {0,-1}, {-1,0},{1,0}};
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            int rx = cur / row;
            int cx = cur % row;
            for (int i = 0; i < directions.length; i ++) {
                int nx = rx + directions[i][0];
                int ny = cx + directions[i][1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[nx][ny] && A[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    visitCnt ++;
                    queue.add(nx * row + ny);
                }
            }
        }
        return total - visitCnt;

    }

    public static void main(String...args) {
        int[][] A = {{0,0,1,1,1,0,1,1,1,0,1},{1,1,1,1,0,1,0,1,1,0,0},{0,1,0,1,1,0,0,0,0,1,0},{1,0,1,1,1,1,1,0,0,0,1},{0,0,1,0,1,1,0,0,1,0,0},{1,0,0,1,1,1,0,0,0,1,1},
                {0,1,0,1,1,0,0,0,1,0,0},{0,1,1,0,1,0,1,1,1,0,0},{1,1,0,1,1,1,0,0,0,0,0},{1,0,1,1,0,0,0,1,0,0,1}};
        System.out.println(new NumberOfEnclaves().numEnclaves(A));
    }
}
