package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by yidianadmin on 14-12-3.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        Set<Integer> used = new HashSet<Integer>();
        Map<Integer, Integer> all = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i ++) {
            all.put(num[i], i);
        }
        for (int i = 0; i < num.length -2; i ++) {
            if (used.contains(num[i])) {continue;}
            for (int j = i+1; i != j && j < num.length-1; j ++) {
                int left = -num[i] - num[j];
                if (all.containsKey(left)) {
                    int index = all.get(left);
                    if (index > i && index > j) {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(-num[i] - num[j]);
                        res.add(tmp);
                    }
                }
            }
            used.add(num[i]);
        }
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        for (List<Integer> li : res) {
            re.add(li);
        }
        return re;
    }
    public static void main(String[] args) {
        int[] num = {-7,-10,-8,-6,-2,-4,-7,-3,-1,-4,-1,7,0,8,5,0};
        List<List<Integer>> res = threeSum(num);
        for (List<Integer> li : res) {
            for (Integer i : li) {
                System.out.println(i + " ");
            }
            System.out.println();
        }
    }
}
