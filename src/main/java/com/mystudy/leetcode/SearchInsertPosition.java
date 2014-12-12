package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-12-11.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if (A== null || A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = A.length-1;
        while (left < right) {
            int mid = left + ((right - left)>>1);
            if (A[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        if (A[left] < target) {
            left += 1;
        }
        return left;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int[] targets = {5,2,7,0};
        for (int target : targets) {
            System.out.println(target);
            int res = new SearchInsertPosition().searchInsert(arr, target);
            System.out.println(res);
        }

    }
}
