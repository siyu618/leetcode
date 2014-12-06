package com.mystudy.leetcode;

import java.util.Arrays;

/**
 * Created by yidianadmin on 14-12-4.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num.length < 3) {
            return -1;
        }
        Arrays.sort(num);
        int closest = num[0] + num[1] + num[2];
        for (int i = 0; i < num.length - 2; i++) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum > target) {
                    k--;
                } else if (sum == target) {
                    return target;
                } else {
                    j++;
                }
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
            }

        }
        return closest;
    }
}
