package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by yidianadmin on 14-12-12.
 */
public class Subsets {
    public Integer[] sortUnique(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : arr) {
            set.add(i);
        }
        Integer[] unique = set.toArray(new Integer[0]);
        Arrays.sort(unique);
        return unique;
    }

    public void getSubset(List<List<Integer>> res, boolean[] flag, Integer[] set, int index) {
        if (index == flag.length) {
            List<Integer> lis = new ArrayList<Integer>();
            for (int i = 0; i < flag.length; i ++) {
                if (flag[i]) {
                    lis.add(set[i]);
                }
            }
            res.add(lis);
            return;
        }
        flag[index] = true;
        getSubset(res, flag, set, index+1);
        flag[index] = false;
        getSubset(res, flag, set, index+1);
    }

    public List<List<Integer>> subsets(int[] S) {
        if (S == null || S.length == 0) {
            return null;
        }
        Integer[] sorted = sortUnique(S);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean[] flag = new boolean[sorted.length];
        getSubset(res, flag, sorted, 0);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2,2,3};
        List<List<Integer>> res = new Subsets().subsets(arr);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }
}
