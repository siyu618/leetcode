package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-1-3.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        int left = 0;
        int right = A.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (A[mid] == target) return mid;
            else if (A[left] <= A[mid]) {
                if (A[left] <=target && target <=A[mid]) {
                    right = mid -1;
                }else {
                    left = mid + 1;
                }
            }
            else {
                if (A[mid] <= target && target <= A[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 8;
        System.out.println(new SearchInRotatedSortedArray().search(arr, target));
    }
}