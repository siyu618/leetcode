package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianyuzhi on 17/9/15.
 */
public class NumberOfLongestIncreasingSubsequence673 {
    public static class Pair {
        public int num;
        public int count;
        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    public int findNumberOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        List<List<Pair>> res = new ArrayList<>(nums.length+1);
        for (int i = 0; i <= nums.length + 1; i ++) {
            res.add(new ArrayList<>());
        }
        res.get(0).add(new Pair(Integer.MIN_VALUE, 1));
        for (int i  = 0; i < nums.length; i ++) {
            int curNum = nums[i];
            for (int j = i; j >= 0; j --) {
                int cnt = 0;
                for (Pair pair : res.get(j)) {
                    if (curNum > pair.num) {
                        cnt += pair.count;
                    }
                }
                if (cnt > 0) {
                    Pair nPair = new Pair(curNum, cnt);
                    res.get(j + 1).add(nPair);
                }
            }
        }
        for (int i = res.size()-1; i >=0;i --) {
            if (res.get(i).size() > 0) {
                int tm = 0;
                for (Pair pair : res.get(i)) {
                    tm += pair.count;
                }
                return tm;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence673 test = new NumberOfLongestIncreasingSubsequence673();
        int[] arr = {1,3,5,4,7};
        System.out.println(test.findNumberOfLIS(arr));
    }
}
