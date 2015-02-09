package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-2-7.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        int[] xDir = {0,1,0,-1};
        int[] yDir = {1,0,-1,0};
        int dirPos = 0;
        int x = 0;
        int y = -1;
        int yStep = n;
        int xStep = n-1;
        int num = 0;
        while (num < n*n) {
            for (int i = 0; i < yStep; i ++) {
                x = x + xDir[dirPos];
                y = y + yDir[dirPos];
                res[x][y] = ++num;
            }
            yStep --;
            dirPos = (dirPos+1)%4;
            for (int j = 0; j < xStep; j ++) {
                x = x + xDir[dirPos];
                y = y + yDir[dirPos];
                res[x][y] = ++num ;
            }
            xStep --;
            dirPos = (dirPos+1)%4;
        }
        return res;

    }
}
