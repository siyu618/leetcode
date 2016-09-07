package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tianyuzhi on 16/5/20.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        List<String> list = new ArrayList<>(nums.length);
        for (int i : nums) {
            list.add(i +"");
        }
        Collections.sort(list, (o1, o2) -> {
            int cmp = o1.compareTo(o2);
            if (cmp == 0) {
                return 0;
            }
            if (cmp < 0) {
                if (o2.startsWith(o1)) {
                    return o2.charAt(o1.length()) - o2.charAt(0);

                }
                else {
                    return -1;
                }
            }
            else {
                if (o1.startsWith(o2)) {
                    return o1.charAt(o2.length() ) - o1.charAt(0);
                }
                else {
                    return 1;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        int len = list.size();
        for (int i = len -1; i >=0 ; i --) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
