package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 15/11/3.
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        //int[][] arr = new int[len][len];
        int[] arr = new int[len];
        int max = 0;
        for (int i = 0; i < len; i ++) {
            arr[i] = 1;
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    int tm = arr[j] + 1;
                    if (arr[i] < tm) {
                        arr[i] = tm;
                    }
                }
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;

    }
    public int lowerBound(int[] arr, int start, int end, int key) {
        while (start < end) {
            int mid = start + ((end - start)>>1);
            if (arr[mid] >= key) {
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        return start;
    }


    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] lenMin = new int[len];
        lenMin[0] = nums[0];
        int index = 0;
        for (int cur : nums) {
            if (cur <= lenMin[0]) {
                lenMin[0] = cur;
                continue;
            }
            else if (cur > lenMin[index]) {
                lenMin[++index] = cur;
                continue;
            } else {
                lenMin[lowerBound(lenMin, 0, index, cur)] = cur;
            }
        }
        return index+1;

    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        int[] arr = {3,5,6,2,5,4,19,5,6,7,12};//{10,9,2,5,3,7,101,18};
        System.out.println(obj.lengthOfLIS(arr));
        System.out.println(obj.lengthOfLIS2(arr));
    }
}
