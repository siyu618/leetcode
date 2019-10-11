package com.mystudy.leetcode.leetcode2;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class ContainsDuplicateIII220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (null == nums || nums.length < 2 || k < 1 || t < 0) {
            return false;
        }
        LinkedHashMap<Long, Integer> map = new LinkedHashMap(k);

        int tt = t > 0 ? t : 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            long bucket = Math.floorDiv((long) num , tt);
            for (long b : new long[]{bucket - 1, bucket, bucket + 1}) {
                if (map.containsKey(b) && Math.abs(num - map.get(b)) <= t) {
                    return true;
                }
            }
            map.put(bucket, num);
            if (i >= k) {
                if (!map.isEmpty()) {
                    map.remove(map.entrySet().iterator().next().getKey());
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (null == nums || nums.length < 2 || k < 1 || t < 0) {
            return false;
        }
        TreeMap<Long, Integer> map = new TreeMap();
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long up = num + t;
            long low = num - t;
            if (map.ceilingEntry(low) != null
                    && Math.abs(map.ceilingEntry(low).getKey() - num) <= t
                    && Math.abs(i - map.ceilingEntry(low).getValue()) <= k) {
                return true;
            } else if (map.floorEntry(up) != null
                    && Math.abs(map.floorEntry(up).getKey() - num) <= t
                    && Math.abs(i - map.floorEntry(up).getValue()) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

    public static void main(String... args) {
        test();
    }

    public static void test() {
        int[] nums = {-1,2147483647};

        int k = 1;
        int t = 2147483647;
        System.out.println(new ContainsDuplicateIII220().containsNearbyAlmostDuplicate(nums, k, t));

    }

    public static void test2() {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        int t = 0;
        System.out.println(new ContainsDuplicateIII220().containsNearbyAlmostDuplicate(nums, k, t));
    }
}