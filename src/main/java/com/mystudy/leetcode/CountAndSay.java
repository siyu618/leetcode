package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-12-17.
 */
public class CountAndSay {

    public String count(String str) {
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        for (int i  = 0; i < arr.length;) {
            char ch = arr[i];
            int j = i + 1;
            for (; j < arr.length && arr[j] == ch; j++){}

            sb.append((j-i) + "").append(ch);
            i = j;

        }
        return sb.toString();

    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String cur = "1";
        while (n > 1) {
            System.out.println(cur);
            cur = count(cur);
            n --;
        }
        return cur;
    }
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(14));
    }
}
