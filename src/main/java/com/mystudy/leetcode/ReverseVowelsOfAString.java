package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 16/5/18.
 */
public class ReverseVowelsOfAString {
    private boolean isVowels(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }
    public String reverseVowels(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] arr = new char[s.length()];
        for (int i = 0, j = s.length() -1; i <= j;) {
            while (i < j && !isVowels(s.charAt(i))) {
                arr[i] = s.charAt(i);
                i ++;
            }
            while(j>i && !isVowels(s.charAt(j))) {
                arr[j] = s.charAt(j);
                j --;
            }
            if (i <= j) {
                arr[i] = s.charAt(j);
                arr[j] = s.charAt(i);
                i ++;
                j --;
            }
        }
        return new String(arr);
    }

     public static void main(String[] args) {
         ReverseVowelsOfAString test = new ReverseVowelsOfAString();
         System.out.println(test.reverseVowels(" "));
     }
}
