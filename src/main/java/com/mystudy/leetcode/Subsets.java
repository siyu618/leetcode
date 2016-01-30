//package com.mystudy.leetcode;
//
//import java.util.*;
//
///**
// * Created by yidianadmin on 14-12-12.
// */
//public class Subsets {
//    public static class NumCountPair {
//        public int num;
//        public int count;
//        public NumCountPair(int num, int count) {
//            this.count = count;
//            this.num = num;
//        }
//    }
//
//    public Integer[] sortUnique(int[] arr) {
//        Set<Integer> set = new HashSet<Integer>();
//        for (int i : arr) {
//            set.add(i);
//        }
//        Integer[] unique = set.toArray(new Integer[0]);
//        Arrays.sort(unique);
//       // Arrays.sort(arr);
//        return unique;
//    }
//
//    public List<NumCountPair> getNumPairs(int[] s) {
//        if (s == null || s.length == 0) {
//            return new ArrayList<>();
//        }
//        List<NumCountPair> rs =
//    }
//
//    public void getSubset(List<List<Integer>> res, int[] count, NumCountPair[] set, int index) {
//        if (index == count.length) {
//            List<Integer> lis = new ArrayList<Integer>();
//            for (int i = 0; i < count.length; i ++) {
//                for (int j = 0; j < count[i]; j++)
//                    lis.add(set[i].num);
//                }
//            }
//            res.add(lis);
//            return;
//        }
//        flag[index] = true;
//        getSubset(res, flag, set, index+1);
//        flag[index] = false;
//        getSubset(res, flag, set, index+1);
//    }
//
//    public List<List<Integer>> subsets(int[] S) {
//        if (S == null || S.length == 0) {
//            return null;
//        }
//        List<>
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        int[] count = new int[S.length];
//        getSubset(res, count, S, 0);
//        return res;
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {1,2,2};
//        List<List<Integer>> res = new Subsets().subsets(arr);
//        for (List<Integer> list : res) {
//            for (int i : list) {
//                System.out.print(i+"\t");
//            }
//            System.out.println();
//        }
//    }
//}
