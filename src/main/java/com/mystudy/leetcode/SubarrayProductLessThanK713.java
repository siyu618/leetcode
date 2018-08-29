package com.mystudy.leetcode;


import java.util.ArrayList;
import java.util.List;
/**
 * Created by tianyuzhi on 18/8/22.
 */
public class SubarrayProductLessThanK713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        List<int[]> pairs = getPairs(nums, k);
        for (int[] pair : pairs) {
            res += count(pair[0], pair[1], nums, k);
        }
        return res;
    }

    private int count(int i, int j, int[] nums, int k)  {
        int prod = nums[i];
        int start = i;
        int end = i;
        int res = 0;
        while (start <= j) {
            while (end + 1 <= j && prod * nums[end + 1] < k) {
                prod *= nums[end+1];
                end ++;
            }
            res += end - start + 1;
            prod /= nums[start];
            start ++;
        }
        return res;
    }

    private List<int[]> getPairs(int[] nums, int k) {
        List<int[]> res = new ArrayList<>();
        int len = nums.length;
        for (int start = 0, end = 0; start < len && end < len; ) {
            while (start < len && nums[start] >= k) {
                start ++;
            }
            if (start < len) {
                end = start;
                while (end < len && nums[end] < k) {
                    end ++;
                }
                res.add(new int[]{start, end-1});
                start = end;
            }
        }
        return res;
    }

    public static void main(String... args) {
        int[] arr = {100, 10, 5, 2, 6, 100};
        int k = 100;
        System.out.println(new SubarrayProductLessThanK713().numSubarrayProductLessThanK(arr, k));
    }
}

