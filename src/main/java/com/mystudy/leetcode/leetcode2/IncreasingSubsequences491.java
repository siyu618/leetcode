package com.mystudy.leetcode.leetcode2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences491 {
    private String join(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(",").append(i);
        }
        return sb.toString();
    }
    private List<List<Integer>> unique(List<List<Integer>> listList) {
        List<List<Integer>> res = new ArrayList();
        Set<String> set = new HashSet();
        for (List<Integer> list : listList) {
            String sb = join(list);
            if (!set.contains(sb)) {
                res.add(list);
            }
            set.add(sb);
        }
        return res;
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (null == nums) {
            return new ArrayList();
        }
        int len = nums.length;
        List< List<List<Integer>>> dp = new ArrayList(len);
        for (int i = 0; i < len; i ++) {
            dp.add(new ArrayList());
            //List<Integer> list = new ArrayList();
            //list.add(nums[i]);
            // dp[i].add(list);
        }

        List<List<Integer>> res = new ArrayList();

        for (int i = 1; i < len; i ++) {
            for (int j = 0; j < i ; j ++) {
                if (nums[i] >= nums[j]) {
                    for (List<Integer> list : dp.get(j)) {
                        List<Integer> nList = new ArrayList(list);
                        nList.add(nums[i]);
                        dp.get(i).add(nList);
                    }
                    List<Integer> nList = new ArrayList(2);
                    nList.add(nums[j]);
                    nList.add(nums[i]);
                    dp.get(i).add(nList);
                }
            }
            res.addAll(dp.get(i));
        }
        //return res;
        return unique(res);
    }

    public  static void main(String... args) {
        int[] nums = {4,6,7,7};
        List<List<Integer>> res = new IncreasingSubsequences491().findSubsequences(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
