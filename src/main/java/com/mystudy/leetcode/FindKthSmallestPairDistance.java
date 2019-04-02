package com.mystudy.leetcode;

import java.util.Arrays;

public class FindKthSmallestPairDistance {

    private int upBound(int[] nums, int low, int high, int x) {
        while (low < high) {
            int mid = low + ((high-low+1)>>1);
            if (nums[mid] - x <= 0) {
                low = mid;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }
    private int count(int[] nums, int x) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i ++) {
            cnt += upBound(nums, i, nums.length-1, x + nums[i]) - i;
        }
        return cnt;
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int len = nums.length;
        int high = nums[len-1] - nums[0];
        while (low < high) {
            int mid = low + ((high-low)>>1);
            int cnt = count(nums, mid);
            if (cnt < k) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
//        int[] nums = {1,3,1};
//        int k = 1;
        int[] nums = {62,100,4};
        int k = 2;
        System.out.println(new FindKthSmallestPairDistance().smallestDistancePair(nums, k));
    }
}
