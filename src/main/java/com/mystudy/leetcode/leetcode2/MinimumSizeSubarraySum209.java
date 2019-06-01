package com.mystudy.leetcode.leetcode2;


import java.util.Map;
import java.util.TreeMap;

public class MinimumSizeSubarraySum209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (null ==  nums || nums.length < 1) {
            return 0;
        }
        int len = nums.length;
        int minLen = len + 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        for (int i = 0; i < len; i ++) {
            sum += nums[i];
            if (sum >= s) {
                Map.Entry<Integer, Integer> entry = map.floorEntry(sum - s);
                if (entry == null) {
                    minLen = Math.min(minLen, i+1);
                }
                else {
                    minLen = Math.min(minLen, i - entry.getValue());
                }
            }
            map.put(sum, i);
        }
        if (sum < s) {
            return 0;
        }
        return minLen;

    }

    public int minSubArrayLen3(int s, int[] nums) {
        if (null ==  nums || nums.length < 1) {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int curSum = 0;
        int minSize = Integer.MAX_VALUE;

        for (int i = 0; i < len; i ++) {
            curSum += nums[i];
            if (curSum >= s) {
                while (left < i && curSum - nums[left] >= s) {
                    curSum -= nums[left];
                    left ++;
                }
                minSize = Math.min(minSize, i - left + 1);
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;

    }

    public int minSubArrayLen2(int s, int[] nums) {
        if (null ==  nums || nums.length < 1) {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int right = -1;
        int curSum = 0;
        int minSize = len;
        int totalSum = 0;

        while (left < len) {
            while (right + 1 < len && curSum + nums[right+1] < s) {
                right ++;
                curSum += nums[right];
            }
            if (right + 1 < len && curSum < s) {
                right ++;
                curSum += nums[right];
            }
            if (curSum >= s) {
                minSize = Math.min(minSize, right - left + 1);
            }
            totalSum += nums[left];
            curSum -= nums[left];
            left ++;
        }
        if (totalSum < s) {
            return 0;
        }
        return minSize;

    }
    public static void main(String... args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        int x = 15;
        int[] nums2 = {1,2,3,4,5};
        int s3 = 11;
        int[] nums3 = {1,2,3,4,5};
        MinimumSizeSubarraySum209 test = new MinimumSizeSubarraySum209();
        System.out.println(test.minSubArrayLen(s3, nums3));

        System.out.println(test.minSubArrayLen(x, nums2));
        System.out.println(test.minSubArrayLen(s, nums));
    }
}
