package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-2-8.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int [][] matrix = new int[m+1][n+1];
        for (int i = 0; i <= m; i ++) {matrix[i][0] = 0;}
        for (int j = 0; j <= n; j ++) {matrix[0][j] = 0;}
        matrix[1][0] = 1;
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }
        return matrix[m][n];
    }
}
