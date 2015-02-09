package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-2-8.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int [][] matrix = new int[m+1][n+1];
        matrix[0][0] = 0;
        for (int i = 1; i <= m; i ++) {matrix[i][0] = 0;}
        for (int j = 1; j <= n; j ++) {matrix[0][j] = 0;}
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j++) {
                int a = i == 1 ? Integer.MAX_VALUE : matrix[i-1][j];
                int b = j == 1 ? Integer.MAX_VALUE : matrix[i][j-1];
                if (i == 1 && j == 1) {
                    a = b = 0;
                }
                matrix[i][j] = Math.min(a, b) + grid[i-1][j-1];
            }
        }
        return matrix[m][n];

    }
    public static void main(String[] args) {
        int[][] grid = {{0,1},{1,0}};
        new MinimumPathSum().minPathSum(grid);
    }
}
