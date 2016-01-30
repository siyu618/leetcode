package com.mystudy.leetcode;

import java.util.Arrays;

/**
 * Created by tianyuzhi on 16/1/7.
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length;i ++) {
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp);
        int index = 0;
        for (int i = 0, j = nums.length -1; i <= j; i ++, j --) {
            if (i != j) {
                nums[index++] = tmp[i];
                nums[index++] = tmp[j];
            }
            else {
                nums[index++] = tmp[i];
            }
        }
    }
    public static void main(String[] args) {
        WiggleSortII wiggleSortII = new WiggleSortII();
        int arr[] = {1,5,1,1,6,4};
        wiggleSortII.wiggleSort(arr);
    }
}
