package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-3-3.
 */
public class EditDistance {
    public int minDistance2(String word1, String word2) {
        if (word1 == word2) {return 0;}
        if (word1 == null) {return word2.length();}
        if (word2 == null) {return word1.length();}
        int rows = word1.length();
        int cols = word2.length();
        int[][] matrix = new int[rows+1][cols+1];
        for (int i = 0; i <= rows; i ++) {
            for  (int j = 0; j <= cols; j ++) {
                matrix[i][j] = -1;
            }
        }
        for (int i = 0; i <=rows; i ++) {matrix[i][0] = i;}
        for (int i = 0; i <=cols; i ++) {matrix[0][i] = i;}
        for (int j = 1; j <= cols; j ++) {
            for (int i = 1; i <= rows; i ++) {
                int d1 = matrix[i-1][j] + 1;
                int d2 = matrix[i][j-1] + 1;
                int d3 = matrix[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1);
                matrix[i][j] = Math.min(d1, Math.min(d2, d3));
            }
        }
        return matrix[rows][cols];
    }

    public int minDistance(String word1, String word2) {
        if (word1 == word2) {return 0;}
        if (word1 == null) {return word2.length();}
        if (word2 == null) {return word1.length();}
        int rows = word1.length();
        int cols = word2.length();
        int[][] matrix = new int[rows+1][cols+1];
        for (int i = 0; i <= rows; i ++) {
            for  (int j = 0; j <= cols; j ++) {
                matrix[i][j] = -1;
            }
        }
        for (int i = 0; i <=rows; i ++) {matrix[i][0] = i;}
        for (int i = 0; i <=cols; i ++) {matrix[0][i] = i;}
        return _minDistance(word1, word2, matrix, rows, cols);
    }

    private int _minDistance(String word1, String word2, int[][] matrix, int row, int col) {
        if (matrix[row][col] != -1) { return matrix[row][col];}
        int d1 = _minDistance(word1, word2, matrix, row-1, col) + 1;
        int d2 = _minDistance(word1, word2, matrix, row, col-1) + 1;
        int d3 = _minDistance(word1, word2, matrix, row-1, col-1) + (word1.charAt(row-1) == word2.charAt(col-1) ? 0 : 1);
        matrix[row][col] = Math.min(d1, Math.min(d2, d3));
        return matrix[row][col];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance("123", "123"));
    }
}
