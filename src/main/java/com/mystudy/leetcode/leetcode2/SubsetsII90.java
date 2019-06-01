package com.mystudy.leetcode.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>>  res = new ArrayList();
        List<Integer> cur = new ArrayList();
        if (null == nums || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, 0, cur, res);
        return res;
    }

    private void dfs(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res) {
        List<Integer> copy = new ArrayList(cur);
        res.add(copy);
        if (idx == nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; i ++) {
            if (i > idx && nums[i] == nums[i-1]) {
                continue;
            }
            cur.add(nums[i]);
            dfs(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String...args) {
        int[] nums = {1,2,2};
        List<List<Integer>> res = new SubsetsII90().subsetsWithDup(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
