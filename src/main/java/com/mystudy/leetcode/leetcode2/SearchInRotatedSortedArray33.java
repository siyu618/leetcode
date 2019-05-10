package com.mystudy.leetcode.leetcode2;

public class SearchInRotatedSortedArray33 {

    private int findSplitPoint(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        if (nums[0] < nums[nums.length - 1]) {
            return 0;
        }
        while (low < high) {
            int mid = low + ((high - low+1) >> 1);
            if (nums[mid] > nums[0]) {
                low = mid;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int find(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + ((high-low)>>1);
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int splitPos = findSplitPoint(nums);
        int left = find(nums, 0, splitPos , target);
        int right = find(nums, splitPos+1, nums.length - 1, target);
        if (left != -1) {
            return left;
        }
        else if (right != -1) {
            return right;
        }
        return -1;
    }

    public static void main(String... args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(new SearchInRotatedSortedArray33().search(nums, target));
    }

}
