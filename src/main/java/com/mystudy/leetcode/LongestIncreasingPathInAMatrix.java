package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 16/9/28.
 */
public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[][] maxCount = new int[rowCount][colCount];
        int res = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                res = Math.max(res, count(i, j, matrix, maxCount, rowCount, colCount));
            }
        }
        return res;

    }

    public int count(int rowIndex, int colIndex, int[][] matrix, int[][] maxCount, int rowCount, int colCount) {
        if (maxCount[rowIndex][colIndex] != 0) {
            return maxCount[rowIndex][colIndex];
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int max = 0;
        for (int i = 0; i < 4; i++) {
            int nRow = rowIndex + directions[i][0];
            int nCol = colIndex + directions[i][1];
            if (!(nRow >= 0 && nRow < rowCount && nCol >= 0 && nCol < colCount)) {
                continue;
            } else {
                if (matrix[rowIndex][colIndex] > matrix[nRow][nCol]) {
                    max = Math.max(max, count(nRow, nCol, matrix, maxCount, rowCount, colCount) + 1);
                }
            }
        }
        if (0 == max) {
            maxCount[rowIndex][colIndex] = 1;
        } else {
            maxCount[rowIndex][colIndex] = max;
        }
        return maxCount[rowIndex][colIndex];
    }

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix test = new LongestIncreasingPathInAMatrix();
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(test.longestIncreasingPath(matrix));

        int[][] nums = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        System.out.println(test.longestIncreasingPath(nums));

    }
}
