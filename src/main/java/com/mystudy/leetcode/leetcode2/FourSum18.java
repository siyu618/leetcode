package com.mystudy.leetcode.leetcode2;

import java.util.*;

public class FourSum18 {
    private Map<Integer, List<int[]>> buildSumMap(int[] nums) {
        Map<Integer, List<int[]>> sumMap = new HashMap();
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                int sum = nums[i] + nums[j];
                List<int[]> cur = sumMap.getOrDefault(sum, new LinkedList());
                cur.add(new int[]{i, j});
                sumMap.put(sum, cur);
            }
        }
        return sumMap;
    }

    private int cal(int a, int b, int c, int d) {
        return a * 16067 + b * 8893  + c * 659 + d * 17;
    }
    private boolean isDuplicate(int a, int b, int c, int d, Set<Integer> set) {
        int tm = cal(a, b, c, d);
        return set.contains(tm);
    }
    private void add(int a, int b, int c, int d, Set<Integer> set) {
        int tm = cal(a,b,c,d);
        set.add(tm);
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Map<Integer, List<int[]>> sumMap  = buildSumMap(nums);
        List<List<Integer>> res = new ArrayList();
        int len = nums.length;
        Set<Integer> duplicate = new HashSet<>();
        for (int i = 0; i < len; i ++) {
            for (int j = i + 1; j < len; j ++ ) {
                List<int[]> cur = sumMap.getOrDefault(target - nums[i] - nums[j], new ArrayList());
                for (int[] item : cur) {
                    if (j < item[0] && !isDuplicate(nums[i], nums[j], nums[item[0]], nums[item[1]], duplicate)) {
                        add(nums[i], nums[j], nums[item[0]], nums[item[1]], duplicate);
                        List<Integer> tm = new ArrayList();
                        tm.add(nums[i]);
                        tm.add(nums[j]);
                        tm.add(nums[item[0]]);
                        tm.add(nums[item[1]]);
                        res.add(tm);
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {-3,0,7,-2,-6,-5,1,5,-1,-8,-9,-8,7,1,1,3,1,10};
        int target = 0;
        for (List<Integer> list : new FourSum18().fourSum(nums, target)) {
            System.out.println(list);
        }
    }
}
