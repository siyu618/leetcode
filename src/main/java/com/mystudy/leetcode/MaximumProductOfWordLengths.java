package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by tianyuzhi on 15/12/17.
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) return 0;
        int res = 0;
        int[] bin = new int[words.length];
        for (int i = 0; i < words.length ; i ++) {
            int tm = 0;
            for (int j = 0; j < words[i].length(); j ++) {
                tm |= 1 << (words[i].charAt(j));
            }
            bin[i] = tm;
            for (int j = 0; j < i; j ++) {
                if ((bin[i] & bin[j]) == 0) {
                    res = Math.max(res,  words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
