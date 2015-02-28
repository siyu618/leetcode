package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-2-27.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean rowHasZeros = false;
        boolean colHasZeros = false;
        for (int i = 0; i < row; i ++) {
            if (matrix[i][0] == 0) {
                rowHasZeros = true;
                break;;
            }
        }
        for (int j = 0; j < col; j ++) {
            if (matrix[0][j] == 0) {
                colHasZeros = true;
                break;;
            }
        }
        for (int i=0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < row; i ++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < col; j ++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < col; j ++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < row; i ++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowHasZeros)  for (int i = 0; i < row; i ++) matrix[i][0] = 0;
        if (colHasZeros)  for (int j = 0; j < col; j ++) matrix[0][j] = 0;

    }
}
