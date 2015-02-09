package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-1-29.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        for (int i = 0; i <= n-i; i ++) {
            for (int j = i; j <= n-i-1; j ++) {
                int tmp = matrix[i][j];

                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = matrix[j][n-i];
                matrix[j][n-i] = tmp;
            }
        }
    }
}
