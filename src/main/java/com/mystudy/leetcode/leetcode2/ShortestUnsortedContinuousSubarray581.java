package com.mystudy.leetcode.leetcode2;

public class ShortestUnsortedContinuousSubarray581 {

    public int findUnsortedSubarray(int[] nums) {
        if (null == nums || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int[] leftMax = new int[len];
        int[] rightMin = new int[len];

        leftMax[0] = nums[0];
        rightMin[len-1] = nums[len-1];

        for (int i = 1; i < len; i ++) {
            leftMax[i] = Math.max(leftMax[i-1], nums[i-1]);
        }
        for (int i = len - 2; i >= 0; i --) {
            rightMin[i] = Math.min(rightMin[i+1], nums[i+1]);
        }
        int leftPos = -1;
        int rightPos = -1;
        for (int i = 0; i < len; i ++) {
            if (!(leftMax[i] <= nums[i] && nums[i] <= rightMin[i])) {
                leftPos = i;
                break;
            }
        }
        for (int i = len-1; i >= 0; i --) {
            if (!(leftMax[i] <= nums[i] && nums[i] <= rightMin[i])) {
                rightPos = i;
                break;
            }
        }
        if (leftPos == -1 || rightPos == -1) {
            return 0;
        }
        else {
            return rightPos - leftPos + 1;
        }


    }

    public static void main(String... args) {
        int[] arr = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(new ShortestUnsortedContinuousSubarray581().findUnsortedSubarray(arr));
    }
}
