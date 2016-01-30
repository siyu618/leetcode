package com.mystudy.leetcode;

import java.util.Stack;

/**
 * Created by tianyuzhi on 15/10/1.
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea1(int[] height) {
        if (null == height || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int res = height[0];
        for (int i = 0; i < length; i ++) {
            int minH = height[i];
            int maxArea = height[i];
            for (int j = i; j < length; j ++) {
                if (height[j] <= minH) {
                    minH = height[j];
                }
                maxArea = Math.max(maxArea, minH * (j-i+1) );
            }
            res = Math.max(res, maxArea);
        }
        return res;
    }


    public int largestRectangleArea2(int[] height) {
        if (null == height || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int res = height[0];
        //Pruning
        for (int i = 0; i < length; i ++) {
            for (int k = i+1; k < length; k ++) {
                if (height[k] < height[k-1]) {
                    i = k - 1;
                    break;
                } else {
                    i = k;
                }
            }
            int minH = height[i];
            for (int j = i; j >=0; j --) {
                if (minH > height[j]) {
                    minH = height[j];
                }
                res = Math.max(res, minH * (i -j +1));
            }
        }

        return res;
    }

    public int largestRectangleArea3(int[] height) {
        if (null == height || height.length == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i ++) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                res = Math.max(res, height[stack.pop()] * (i - (stack.isEmpty() ? 0 : stack.peek() + 1)));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            res = Math.max(res, height[stack.pop()] * (height.length - (stack.isEmpty() ? 0 : stack.peek() + 1)));
        }
        return res;
    }

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


    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleArea(height));
    }
}
