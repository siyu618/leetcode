package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by tianyuzhi on 16/6/28.
 */
public class LargestDivisibleSubset {

    public static List<Integer> largestDivisibleSubset1(int[] nums) {
        if (null == nums || nums.length < 1) {
            return new ArrayList<>(0);
        }
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {set.add(num);}

        int len = nums.length;
        int max = nums[len];
        List<Integer> res = new ArrayList<>(0);
        for (int i = 0; i < len; i ++ ) {
            for (int j = i+1; j < len; j ++) {
                if (nums[j] % nums[i] != 0) {
                    continue;
                }
                List<Integer> cur = new ArrayList<>(len);
                cur.add(nums[i]);
                cur.add(nums[j]);
                int div = nums[j] / nums[i];
                int curNum = nums[j];
                while (curNum < max) {
                    int tmp = curNum * div;
                    if (set.contains(tmp)) {
                        cur.add(tmp);
                        curNum = tmp;
                    }
                    else {
                        break;
                    }
                }
                if (cur.size() > res.size()) {
                    res = cur;
                }
            }
        }
        return res;

    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if (null == nums || nums.length < 1) {
            return new ArrayList<>(0);
        }
        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[len+1];
        int[] pre = new int[len+1];
        for (int i = 0; i <= len; i ++) {
            dp[i] = 1;
            pre[i] = -1;
        }
        int max = 1;
        int maxPos = -1;
        for (int i = 0; i < len; i ++) {
            for (int j = i-1; j >= 0; j --) {
                if (nums[i]%nums[j] == 0) {
                    if (dp[i] < dp[j]+1) {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                        if (dp[i]>max) {
                            max = dp[i];
                            maxPos = i;
                        }
                    }
                }
            }
        }
        if (max == 1)
        {
            return Arrays.asList(nums[0]);
        }
        List<Integer> res = new ArrayList<>(len);
        int index = maxPos;
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;

    }

    public static void main(String[] args) {
        int[] ints = {1,2,4,6,8};
        System.out.println(largestDivisibleSubset(ints));
    }
}
