package com.mystudy.leetcode.leetcode2;

public class MajorityElement169 {
    public int majorityElement(int[] nums) {

        int count = 0;
        int item = -1;
        for (int num : nums) {
            if (count == 0) {
                item = num;
            }
            if (num == item) {
                count ++;
            }
            else {
                count --;
            }
        }

//        int cnt = 0;
//        for (int num : nums) {
//            cnt += (item == num) ? 1 : 0;
//        }
//        if (cnt * 2 > nums.length) {
//            return item;
//        }
//        else {
//            return -1;
//        }
        return item;

    }
}
