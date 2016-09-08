package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 16/9/8.
 */
public class UTF8Validation {
    public int countStartOnes(int num) {
        int res = 0;
        for (int i = 0; i < 6; i ++) {
            int tm = (1 << (7-i));
            int a = num & tm;
            if ((num&tm) != 0) {
                res ++;
            }
            else {
                break;
            }
        }
        return res;
    }
    public boolean validUtf8(int[] data) {
        if (null == data || data.length <1 ) {
            return false;
        }
        boolean isValid = true;
        for (int i = 0; i < data.length; ) {
            int ones = countStartOnes(data[i]);
            if (ones == 0) {
                i ++;
            }
            else if (ones >= 2 && ones <=4) {
                if (i + ones > data.length) {return false;}
                for (int j = 1; j < ones; j ++) {
                    i ++;
                    if ( ((data[i] & 0x80) != 0 ) && ((data[i] & 0x40) == 0)) {
                        continue;
                    }
                    else {
                        return false;
                    }
                }
                i ++;
            }
            else {
                return false;
            }
        }
        return isValid;
    }
    public static void main(String[] args) {
        int[] nums = {230,136,145};
        UTF8Validation test = new UTF8Validation();
        System.out.println(test.validUtf8(nums));
    }
}
