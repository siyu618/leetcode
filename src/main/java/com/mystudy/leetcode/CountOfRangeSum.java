package com.mystudy.leetcode;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by tianyuzhi on 16/9/5.
 */
public class CountOfRangeSum {

    public static class SegmentNode {
        public int min;
        public int max;
        public int val;
        public int left;
        public int right;
        private SegmentNode leftChild = null;
        private SegmentNode rightChild = null;

        public SegmentNode(int val, int left, int right) {
            this.left = left;
            this.right = right;
            this.val = val;
            this.min = this.max = val;
        }
    }

    public static SegmentNode buildTree(int[] nums, int left, int right) {
        if (left == right) {
            return new SegmentNode(nums[left], left, right);
        }
        int mid = left + ((right - left) >> 1);
        SegmentNode leftNode = buildTree(nums, left, mid);
        SegmentNode rightNode = buildTree(nums, mid + 1, right);
        SegmentNode root = new SegmentNode(nums[left], left, right);
        root.min = Math.min(leftNode.min, rightNode.min);
        root.max = Math.max(leftNode.max, rightNode.max);
        root.leftChild = leftNode;
        root.rightChild = rightNode;
        return root;
    }

    public static void update(SegmentNode root, int index) {
        if (root == null) {
            return;
        }
        if (root.left <= index && index <= root.right) {
            root.val++;
        }
        int mid = root.left + ((root.right - root.left) >> 1);
        if (index <= mid) {
            update(root.leftChild, index);
        }
        if (mid + 1 <= index) {
            update(root.rightChild, index);
        }
    }

    public static int count(SegmentNode root, int lower, int upper) {
        if (root == null || root.right < lower || root.left > upper) {
            return 0;
        }
        if (lower <= root.left && root.right <= upper) {
            return root.val;
        }
        int res = 0;
        int mid = root.left + ((root.right - root.left) >> 1);
        if (mid >= lower) {
            res += count(root.leftChild, lower, upper);
        }
        if (mid + 1 <= upper) {
            res += count(root.rightChild, lower, upper);
        }
        return res;
    }


    public int countRangeSum(int[] nums, int lower, int upper) {
        if (lower > upper || null == nums || nums.length == 0) {
            return 0;
        }
        int res = 0;
        //Arrays.sort(nums);
        long[] sum = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(Long.MIN_VALUE, 0);
        map.put(Long.MAX_VALUE, 0);
        Arrays.sort(sum);
        for (int i = 0; i < sum.length; i++) {
            map.put(sum[i], i + 1);
        }
        int[] tmp = new int[nums.length + 4];
        SegmentNode root = buildTree(tmp, 0, nums.length);
        long cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            long sumjL = cur - upper;
            long sumjR = cur - lower;
            long left = map.ceilingKey(sumjL);
            long right = map.floorKey(sumjR);
            if(right>=left) {
                res += count(root, map.get(left), map.get(right));
            }
            update(root, map.get(cur));
            if (lower <= cur && cur <= upper) {
                res ++;
            }


        }
        return res;
    }

    public static void main(String[] args) {
        CountOfRangeSum test = new CountOfRangeSum();
//        int[] nums = {-2,5,-1};
//        int lower = -2;
//        int upper = 2;

        int[] nums = {-3, 1, 2, -2, 2, -1};
        int lower = -3;
        int upper = -1;
        System.out.println(test.countRangeSum(nums, lower, upper));
    }
}
