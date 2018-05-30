package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 18/5/29.
 */
public class SearchInRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int minIndex = findMin(nums);
        int leftIdx = find(nums, target, 0, minIndex - 1);
        int rightIdx = find(nums, target, minIndex, nums.length-1);
        return leftIdx != -1 ? leftIdx : rightIdx;
    }
    private int find(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left)>>1);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray33 test = new SearchInRotatedSortedArray33();
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(test.search(arr, 0));

    }
}
