package com.mystudy.leetcode.leetcode2;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation784 {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList();
        char[] arr = S.toCharArray();
        if (!hasLetters(arr)) {
            res.add(S);
            return res;
        }
        dfs(arr, 0, res);
        return res;

    }

    private boolean hasLetters(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (!isDigit(arr[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean isDigit(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    private boolean isUpper(char ch) {
        return (ch >= 'A' && ch <= 'Z');
    }

    private boolean isLower(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    private char toUpper(char ch) {
        if (isLower(ch)) {
            return (char) (ch - 'a' + 'A');
        } else {
            return ch;
        }

    }

    private char toLower(char ch) {
        if (isUpper(ch)) {
            return (char) (ch - 'A' + 'a');
        } else {
            return ch;
        }
    }

    private void dfs(char[] arr, int idx, List<String> res) {
        if (idx == arr.length) {
            res.add(new String(arr));
            return;
        }

        char ch = arr[idx];
        if (!isDigit(ch)) {
            arr[idx] = toLower(ch);
            dfs(arr, idx + 1, res);
            arr[idx] = toUpper(ch);
            dfs(arr, idx + 1, res);
        } else {
            dfs(arr, idx + 1, res);
        }
    }


    public static void main(String... args) {
        String str = "a1b2";
        System.out.println(new LetterCasePermutation784().letterCasePermutation(str));
    }
}
