package com.mystudy.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yidianadmin on 15-2-1.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new LinkedList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int[] xDir = {0,1,0,-1};
        int[] yDir = {1,0,-1,0};
        int dir = 0;
        int xLen = matrix.length-1;
        int yLen = matrix[0].length;
        int curX = 0;
        int curY = -1;
        int total = matrix.length * matrix[0].length;
        while (total > 0) {
            if (dir%2 == 0) {
                for (int j = 0; j < yLen; j ++){
                    curX += xDir[dir];
                    curY += yDir[dir];
                    res.add(matrix[curX][curY]);
                    total -= 1;
                }
                yLen --;
            }else {
                for (int j = 0; j < xLen; j ++){
                    curX += xDir[dir];
                    curY += yDir[dir];
                    res.add(matrix[curX][curY]);
                    total -= 1;
                }
                xLen --;
            }
            dir = (dir+1)%4;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        List<Integer> res = new SpiralMatrix().spiralOrder(matrix);
        for (int i : res) {
            System.out.print(i + "\t");
        }

    }

}
