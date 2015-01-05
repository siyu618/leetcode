package com.mystudy.leetcode;

import java.util.Arrays;

/**
 * Created by yidianadmin on 15-1-3.
 */
public class MajorityElement {
    public int majorityElement2(int[] num) {
        Arrays.sort(num);
        return num[num.length/2];
    }
    public int majorityElement(int[] num) {
        int maj = 0;
        int count = 0;
        for (int i = 0; i < num.length; i ++) {
            if (count == 0) {
                maj = num[i];
                count ++;
            }
            else if (maj == num[i]) {
                count ++;
            }
            else {
                count --;
            }
        }
        return maj;
    }
}
