package com.mystudy.leetcode;

import java.util.Arrays;

/**
 * Created by tianyuzhi on 16/10/11.
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        if (null == nums || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        Arrays.sort(nums);
        int max = sum / 2;
        boolean canReach[][] = new boolean[nums.length][max + 1];
        for (int j = 0; j <= max; j ++) {
            canReach[0][j] = (j == nums[0]);
        }
        for (int i = 0; i< nums.length; i++) {
            canReach[i][0] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = 1; j <= max; j++) {
                if (cur > j) {
                    canReach[i][j] = canReach[i-1][j];
                }
                else {
                    canReach[i][j] = canReach[i-1][j - cur] || canReach[i-1][j] ;
                }
            }
        }
        return canReach[nums.length - 1][max];
    }
}
