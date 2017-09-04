package com.mystudy.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by tianyuzhi on 17/8/17.
 */
public class ContainsDuplicateIII220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (null == nums || k < 1 || t < 0) {
            return false;
        }

        int base = t + 1;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Long bucket = getBucket(nums[i], base);
            if (map.containsKey(bucket) && Math.abs(map.get(bucket) - (long)nums[i]) <= t ) {
                return true;
            }
            else if (map.containsKey(bucket+1) && Math.abs(map.get(bucket+1) - (long)nums[i]) <= t ) {
                return true;
            }
            else if (map.containsKey(bucket-1) && Math.abs(map.get(bucket-1) - (long)nums[i]) <= t ) {
                return true;
            }
            if (i>=k) {
                map.remove(getBucket(nums[i-k], base));
            }
            map.put(bucket, (long)nums[i]);
        }

        return false;
    }
    private long getBucket(long num, long base) {
        return num / base;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (null == nums || k < 1 || t < 0) {
            return false;
        }

        TreeMap<Long, Long> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            long curNum = nums[i];
            if (i - k - 1 >= 0) {
                long toRemove = nums[i-k-1];
                if (map.getOrDefault(curNum, 0L) > 1) {
                    map.put(toRemove, map.getOrDefault(toRemove, 0L)-1);
                }
                else {
                    map.remove(toRemove);
                }
            }
            long from = curNum - t;
            long to = curNum + t + 1 ;
            Map sub = map.subMap(from, to);
            if (null != sub && !sub.isEmpty()) {
                return true;
            }
            map.put(curNum, map.getOrDefault(curNum, 0L) + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        int [] arr = {1,3,1};
        int k = 1;
        int t = 1;
        new ContainsDuplicateIII220().containsNearbyAlmostDuplicate(arr, k, t);
    }
}
