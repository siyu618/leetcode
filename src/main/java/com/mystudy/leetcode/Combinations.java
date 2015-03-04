package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yidianadmin on 15-3-4.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k == 0) {
            return res;
        }



        boolean[] flags = new boolean[n+1];
        for (int i = 1; i <=n; i ++ ) {flags[i] = false;}
        findCombine(n, 1, k, flags, res);
        return res;


    }

    public void findCombine(int n, int startPos, int left, boolean[] flags, List<List<Integer>> res) {
        if (left == 0) {
            List<Integer> one = new ArrayList<Integer>();
            for (int i = 1; i <= n; i ++ ) {
                if (flags[i])  {
                    one.add(i);
                }
            }
            res.add(one);
            return;
        }
        if (startPos > n) {return;}
        for (int i = startPos; i <=n; i ++) {
            flags[i] = true;
            findCombine(n, i+1, left-1, flags, res);
            flags[i] = false;
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> res = combinations.combine(4,2);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

}
