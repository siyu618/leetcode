package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 18/5/30.
 */
public class SearchInRotatedSortedArrayII81 {
    public boolean search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return false;
        }
        int minIndex = findMin(nums);
        int leftIdx = find(nums, target, 0, minIndex - 1);
        int rightIdx = find(nums, target, minIndex, nums.length-1);
        return leftIdx != -1 || rightIdx != -1;
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
//        while (left < right && nums[left] == nums[right]) {
//            right --;
//        }
////        if (nums[left] > nums[right] && right < nums.length - 1) {
////            return right;
////        }
        if (nums[left] < nums[right] && right < nums.length - 1) {
            return right + 1;
        }
        while (left < right) {
            if (nums[left] < nums[right]) {
                return left;
            }
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
        SearchInRotatedSortedArrayII81 test = new SearchInRotatedSortedArrayII81();
        int[] arr = {2,2,2,4,2,2};
        System.out.println(test.search(arr, 4));
        int[] arr2 = {2,5,6,0,0,1,2};
        System.out.println(test.search(arr2, 0));

    }
}
