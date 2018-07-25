package com.mystudy.leetcode;

import java.util.Arrays;

/**
 * Created by tianyuzhi on 18/7/12.
 */
public class PartitionToKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int[] bucketSum = new int[k];
        int avg = sum / k;
        if (nums[0] > avg) {
            return false;
        }
        if (nums[0] != avg && nums[0] + nums[nums.length - 1] > avg) {
            return false;
        }
        return dfs(nums, bucketSum, 0, k, avg);

    }

    private boolean dfs(int[] nums, int[] bucketSum, int idx, int k, int avg) {
        if (idx == nums.length) {
            boolean canSep = true;
            for (int sum : bucketSum) {
                canSep = canSep && sum == avg;
            }
            return canSep;
        }
        int num = nums[idx];
        for (int j = 0; j < k; j++) {
            if (bucketSum[j] + num > avg) {
                continue;
            }
            bucketSum[j] += num;
            boolean canSep = dfs(nums, bucketSum, idx + 1, k, avg);
            if (canSep) {
                return true;
            }
            bucketSum[j] -= num;
        }
        return false;
    }

    /**
     * nums = [4, 3, 2, 3, 5, 2, 5], k = 4
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 5};
        int k = 4;
        System.out.println(new PartitionToKEqualSumSubsets().canPartitionKSubsets(nums, k));
        int[] nums2 = {4, 5, 3, 2, 5, 5, 5, 1, 5, 5, 5, 5, 5, 5, 5, 5};
        int k2 = 14;
        System.out.println(new PartitionToKEqualSumSubsets().canPartitionKSubsets(nums2, k2));

        int[] nums3 = {7628,
                3147,
                7137,
                2578,
                7742,
                2746,
                4264,
                7704,
                9532,
                9679,
                8963,
                3223,
                2133,
                7792,
                5911,
                3979};
        int k3 = 6;
        System.out.println(new PartitionToKEqualSumSubsets().canPartitionKSubsets(nums3, k3));

    }
}
