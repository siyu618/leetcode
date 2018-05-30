package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 18/5/27.
 */
public class LargestRectangleInHistogram84 {
    public int largestRectangleArea(int[] heights) {
        if (null == heights || heights.length == 0) {
            return 0;
        }
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < len; i ++) {
            left[i] = i;
            while (left[i] > 0 && heights[left[i]-1] >= heights[i]) {
                left[i] = left[left[i]-1];
            }
        }
        for (int i = len-1; i >= 0; i --) {
            right[i] = i;
            while (right[i] < len - 1 && heights[right[i] + 1] >= heights[i]) {
                right[i] = right[right[i]+1];
            }
        }
        int res = 0;
        for (int i = 0; i < len; i ++) {
            res = Math.max(res, (right[i]-left[i]+1) * heights[i]);
        }
        return res;

    }

    public static void main(String[] args) {
        LargestRectangleInHistogram84 test = new LargestRectangleInHistogram84();
        System.out.println(test.largestRectangleArea(new int[]{4,2,0,3,2,4,3,4}));
    }
}
