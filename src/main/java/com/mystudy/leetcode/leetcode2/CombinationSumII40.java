package com.mystudy.leetcode.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {

    class Node {
        public List<List<Integer>> list;
        public  Node() {
            list = new ArrayList();
        }
        public void add(List<Integer> sub, int append) {
            List<Integer> newSub = new ArrayList(sub);
            newSub.add(append);
            list.add(newSub);
        }
        public void addList(List<List<Integer>> aList, int append) {
            for (List<Integer> sub : aList) {
                add(sub, append);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        int len = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList();
        Node[][] dp = new Node[len+1][target+1];
        for (int i = 0; i <= len; i ++) {
            dp[i][0] = new Node();
            dp[i][0].list.add(new ArrayList<>());
        }

        for (int i = 0; i < len; i ++)  {
            for (int j = 1; j <= target; j ++) {
                if (j-candidates[i] >= 0 && null != dp[i][j-candidates[i]]) {
                    dp[i+1][j] = new Node();
                    dp[i+1][j].addList(dp[i][j-candidates[i]].list, candidates[i]);
                }
            }
            if (null != dp[i+1][target]) {
                res.addAll( dp[i+1][target].list);
            }
        }
        return res;

    }

    public static void main(String... args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        //[]
        //8
        CombinationSumII40 obj = new CombinationSumII40();
        for (List<Integer> list : obj.combinationSum2(arr, target)) {
            System.out.println(list);
        }
    }

}
