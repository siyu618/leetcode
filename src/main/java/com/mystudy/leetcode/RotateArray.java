package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-2-27.
 */
public class RotateArray
{
    public void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end-1; i < j; i ++, j --) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return;
        }
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len-k);
        reverse(nums, len-k, len);
        reverse(nums, 0, len);

    }
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int nums[] = {1,2,3,4,5,6,7};
        rotateArray.rotate(nums, 3);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
