package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-1-9.
 */
public class MultiplyStrings {
    public boolean isZero(String num) {
        for (char ch : num.toCharArray()) {
            if (ch != '0') {
                return false;
            }
        }
        return true;
    }
    public String multiply(String num1, String num2) {
        // TODO : remove + sign if exists
        if (isZero(num1) || isZero(num2)) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = 0; i < res.length; i ++) {res[i] = 0;}
        int len1 = num1.length();
        int len2 = num2.length();
        for (int i = len1 - 1; i >=0; i --) {
            for (int j = len2 - 1 ; j >= 0; j --) {
                int pos = (len1 - i -1) + (len2-j-1);
                res[pos] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }
        for (int i = 0; i<res.length-1; i ++) {
            res[i+1] += res[i] / 10;
            res[i] = res[i] % 10;
        }
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        for (int i = res.length-1;i>=0;i--) {
            if (first && res[i] == 0) {
                first = false;
                continue;
            }
            else {
                first = false;
            }
            sb.append((char)(res[i]+'0'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("12345", "11111"));
        System.out.println(multiplyStrings.multiply("0000", "234"));

        System.out.println(multiplyStrings.multiply("222", "0"));

    }
}
