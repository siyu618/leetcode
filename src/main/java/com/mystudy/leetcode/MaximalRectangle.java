package com.mystudy.leetcode;

import java.util.Stack;

/**
 * Created by tianyuzhi on 15/10/14.
 */
public class MaximalRectangle {
    public int largestRectangleArea(int[] height) {
        if (null == height || height.length == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= height.length; i ++) {
            int curHeight = (i == height.length) ? -1 : height[i];
            if (stack.isEmpty() || height[stack.peek()] < curHeight) {
                stack.push(i);
            }
            else {
                int tmp = stack.pop();
                res = Math.max(res, height[tmp] * (i - (stack.isEmpty() ? 0 : stack.peek() + 1)));
                i --;
            }
        }
        return res;
    }
    public int maximalRectangle(char[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int[][] dp = new int[rowNum+1][colNum];
        for (int i = 0; i < rowNum; i ++) {
            for (int j = 0; j < colNum; j ++) {
                if (matrix[i][j] == '1') {
                    dp[i+1][j] = dp[i][j] + 1;
                }
            }
        }
        int res = 0;

        for (int i = 1; i <= rowNum; i ++) {
            res = Math.max(res, largestRectangleArea(dp[i]));
        }
        return res;

    }
}
