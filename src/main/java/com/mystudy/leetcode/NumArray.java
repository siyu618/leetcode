package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 15/11/21.
 */
public class NumArray {
    public static class Segment {
        public int start;
        public int end;
        private int sum;
        public Segment left;
        public Segment right;

        public Segment(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = null;
            this.right = null;
        }
    }

    private int[] nums = null;
    private Segment root = null;

    private Segment buildTree(int[] nums, int start, int end) {
        if (start == end) {
            return new Segment(start, end, nums[start]);
        } else {
            Segment root = new Segment(start, end, 0);
            int mid = start + ((end - start) >> 1);
            root.left = buildTree(nums, start, mid);
            root.right = buildTree(nums, mid + 1, end);
            root.sum = root.left.sum + root.right.sum;
            return root;
        }
    }

    private void update(int i, int val, Segment root) {
        int start = root.start;
        int end = root.end;
        if (i < start || i > end) return;
        root.sum = root.sum - nums[i] + val;

        if (start == end) {
            return;
        } else {
            update(i, val, root.left);
            update(i, val, root.right);
        }
    }

    private int sumRange(Segment root, int start, int end) {
        if (root.start >= start && root.end <= end) {
            return root.sum;
        }
        if (start > root.end || end < root.start) return 0;

        int res = sumRange(root.left, start, end) + sumRange(root.right, start, end);

        return res;
    }

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        this.nums = nums;
        root = buildTree(nums, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        update(i, val, root);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    public static void main(String[] args) {
        int[] nums= {1,3,5};
        NumArray numArray = new NumArray(nums);
        numArray.sumRange(0, 1);
        numArray.update(1, 10);
        numArray.sumRange(1, 2);
    }
}
