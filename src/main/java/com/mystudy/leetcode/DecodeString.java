package com.mystudy.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by tianyuzhi on 16/9/8.
 */
public class DecodeString {
    public String build(String str, int n) {
        StringBuilder sb = new StringBuilder(n * str.length());
        for (int i = 0; i < n; i ++) {
            sb.append(str);
        }
        return sb.toString();
    }
    public String decodeString(String str) {
        if (null == str || str.isEmpty() ) {return "";}
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length();) {
            if (Character.isDigit(str.charAt(i))) {
                int j = i;
                while (j < str.length() && Character.isDigit(str.charAt(j))) {
                    j ++;
                }
                int cnt = Integer.parseInt(str.substring(i, j));
                int kStart = j+1; // [
                int kEnd =0;
                int times = 1;
                for (int k = kStart; k < str.length(); k ++) {
                    char ch = str.charAt(k);
                    if (ch == '[') {
                        times ++;
                    }
                    else if (ch == ']') {
                        times --;
                        if (times == 0) {
                            kEnd = k;
                            break;
                        }
                    }
                }
                String inStr = decodeString(str.substring(kStart, kEnd));
                sb.append(build(inStr, cnt));
                i = kEnd+1;
            }
            else if (Character.isLetter(str.charAt(i))) {
                sb.append(str.charAt(i));
                i ++;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        DecodeString test = new DecodeString();
        for (String str : Arrays.asList("3[a]2[bc]",
                "3[a2[c]]",
                "2[abc]3[cd]ef",
                "abcd")) {
            System.out.println(str + ":" + test.decodeString(str));
        }
    }
}

