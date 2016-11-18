package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianyuzhi on 16/11/10.
 */
public class ReconstructOriginalDigitsFromEnglish {
    /**
     * "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
     * z : 0   = num[z]
     * n : 1, 7, 9
     * w : 2   = num[w]
     * h : 3, 8
     * u : 4   = num[u]
     * v : 5, 7
     * x : 6 = num[x]
     * s : 6, 7
     * g : 8 = num[g]
     * i : 5,6,8,9
     * @param s
     * @return
     */
    public String originalDigits(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        int[] total = new int[26];
        int[] times = new int[10];
        for (int i = 0; i < s.length(); i ++) {
            total[s.charAt(i) - 'a'] += 1;
        }
        times[0] = total['z' - 'a'];
        times[2] = total['w' - 'a'];
        times[4] = total['u' - 'a'];
        times[6] = total['x' - 'a'];
        times[8] = total['g' - 'a'];

        times[3] = total['h' - 'a'] - times[8];
        times[7] = total['s' - 'a'] - times[6];
        times[5] = total['v' - 'a'] - times[7];
        times[9] = total['i' - 'a'] - times[5] - times[6] - times[8];
        times[1] = total['n' - 'a'] - times[7] - 2*times[9];

        String res = "";
        for (int i = 0; i < 10; i ++) {
            for (int j = 0; j < times[i]; j ++) {
                res += i;
            }
        }

        return res;
    }
    // zero one two three four five six serven eight nine
    public String originalDigits2(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        int[] total = new int[26];
        int sum = 0;
        for (int i = 0; i < s.length(); i ++) {
            total[s.charAt(i) - 'a'] += 1;
            sum ++;
        }
        List<String> res = new ArrayList<>();
        List<String> digits = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        dfs(digits, res, 0, total,sum);
        StringBuilder sb = new StringBuilder();

        for (String str : res) {
            sb.append(str);
        }
        return sb.toString();

    }

    public boolean dfs( List<String> digits , List<String> res, int index, int[] total, int sum) {
        if (sum == 0 || index >= 10) {
            return true;
        }
        String str = digits.get(index);
        while (true) {
            boolean canMatch = isCanMatch(total, str);
            if (canMatch) {
                int tmpSum = 0;
                for (int j  = 0; j < str.length(); j ++) {
                    total[str.charAt(j) - 'a'] -= 1;
                    tmpSum ++;
                }
                res.add(index + "");
                boolean find = dfs(digits, res, index, total, sum-tmpSum);
                if (!find) {
                    for (int j = 0; j < str.length(); j++) {
                        total[str.charAt(j) - 'a'] += 1;
                    }
                    res.remove(index + "");
                    return dfs(digits, res, index+1, total, sum);
                }
                else {
                    return true;
                }

            }
            else {
                return dfs(digits, res, index+1, total, sum);
            }
        }

    }

    private boolean isCanMatch(int[] total, String str) {
        boolean canMatch = true;
        for (int j  = 0; j < str.length(); j ++) {
            int tm = str.charAt(j) - 'a';
            if (total[tm] < 1) {
                canMatch = false;
                break;
            }
        }
        return canMatch;
    }


    public static void main(String[] args) {
        System.out.println(new ReconstructOriginalDigitsFromEnglish().originalDigits("fviefuro"));
    }
}
