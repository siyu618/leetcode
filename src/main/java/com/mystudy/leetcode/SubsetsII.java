package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by tianyuzhi on 15/10/1.
 */
public class SubsetsII {
    public static class NumCountPair {
        public int num;
        public int count;

        public NumCountPair(int num, int count) {
            this.count = count;
            this.num = num;
        }
    }


    public List<NumCountPair> getNumPairs(int[] s) {
        if (s == null || s.length == 0) {
            return new ArrayList<>();
        }
        List<NumCountPair> pairs = new ArrayList<>(s.length);
        Arrays.sort(s);
        for (int i = 0; i < s.length; ) {
            int num = s[i];
            int count = 1;
            int j = i + 1;
            i = j;
            for (; j < s.length; j++) {
                if (num == s[j]) {
                    count++;
                    i = j + 1;
                } else {
                    i = j;
                    break;
                }
            }
            pairs.add(new NumCountPair(num, count));
        }
        return pairs;
    }

    public void getSubset(List<List<Integer>> res, int[] count, NumCountPair[] set, int index) {
        if (index == count.length) {
            List<Integer> lis = new ArrayList<>();
            for (int i = 0; i < count.length; i++) {
                for (int j = 0; j < count[i]; j++)
                    lis.add(set[i].num);
            }
            res.add(lis);
            return;
        }
        for (int i = 0; i <= set[index].count; i ++) {
            count[index] = i;
            getSubset(res, count, set, index + 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] S) {
        if (S == null || S.length == 0) {
            return null;
        }
        List<NumCountPair> pairs = getNumPairs(S);
        List<List<Integer>> res = new ArrayList<>();
        int[] count = new int[pairs.size()];
        NumCountPair[] pairs1 = pairs.toArray(new NumCountPair[0]);
        getSubset(res, count, pairs1, 0);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        List<List<Integer>> res = new SubsetsII().subsetsWithDup(arr);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
