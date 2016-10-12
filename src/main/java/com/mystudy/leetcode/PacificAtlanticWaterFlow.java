package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianyuzhi on 16/10/11.
 */
public class PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int[][] canReachTopLeft = new int[rowNum][colNum];
        int[][] canReachBottomRight = new int[rowNum][colNum];
        // int[4][2] directions = {{0, 1, 0, -1}, {1, 0, -1, 0}};
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//        for (int i = 0; i < rowNum; i++) {
//            canReachTopLeft[i][0] = 1;
//            canReachBottomRight[i][colNum - 1] = 1;
//        }
//        for (int j = 0; j < colNum; j++) {
//            canReachTopLeft[0][j] = 1;
//            canReachBottomRight[rowNum - 1][j] = 1;
//        }

        for (int i = 0; i < rowNum; i++) {
            cal(matrix, i, 0, directions, rowNum, colNum, canReachTopLeft);
            cal(matrix, i, colNum - 1, directions, rowNum, colNum, canReachBottomRight);
        }
        for (int j = 0; j < colNum; j++) {
            cal(matrix, 0, j, directions, rowNum, colNum, canReachTopLeft);
            cal(matrix, rowNum - 1, j, directions, rowNum, colNum, canReachBottomRight);
        }
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (canReachTopLeft[i][j] == 1 && canReachBottomRight[i][j] == 1) {
                    int[] tm = new int[2];
                    tm[0] = i;
                    tm[1] = j;
                    res.add(tm);
                    System.out.println(i + " " + j);
                }
            }
        }
        return res;
    }

    private void cal(int[][] matrix, int rowIndex, int colIndex,
                     int[][] directions, int rowNum, int colNum, int[][] canReach) {
        canReach[rowIndex][colIndex] = 1;
        for (int i = 0; i < 4; i++) {
            int newR = rowIndex + directions[i][0];
            int newC = colIndex + directions[i][1];
            if (newR >= 0 && newR < rowNum
                    && newC >= 0 && newC < colNum
                    && canReach[newR][newC] == 0
                    && matrix[rowIndex][colIndex] <= matrix[newR][newC]) {
                cal(matrix, newR, newC, directions, rowNum, colNum, canReach);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        PacificAtlanticWaterFlow test = new PacificAtlanticWaterFlow();

        System.out.println(test.pacificAtlantic(matrix));
    }

}

