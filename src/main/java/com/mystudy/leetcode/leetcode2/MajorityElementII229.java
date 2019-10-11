package com.mystudy.leetcode.leetcode2;

import java.util.*;

public class MajorityElementII229 {

    private List<Integer> majorityElement(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(k);
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.size() == k) {
                for (int key : new HashSet<Integer>(map.keySet())) {
                    if (map.get(key) == 1) {
                        map.remove(key);
                    }
                    else {
                        map.put(key, map.get(key) - 1);
                    }
                }
            }
        }

        for (int key : new HashSet<Integer>(map.keySet())) {
            map.put(key, 0);
        }
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) * k > nums.length) {
                res.add(key);
            }
        }
        return res;
    }

    public List<Integer> majorityElement(int[] nums) {
        return majorityElement(nums, 3);
    }
}
