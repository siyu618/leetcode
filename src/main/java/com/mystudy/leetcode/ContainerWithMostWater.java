package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-11-30.
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right --;
            }
            else {
                left ++;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] A = {5, 4, 6, 7, 4};
        System.out.println(maxArea(A));
    }
}
